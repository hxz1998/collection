/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.OpenContext;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction.Context;
import org.apache.flink.streaming.api.windowing.evictors.CountEvictor;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.windowing.windows.Window;
import org.apache.flink.util.Collector;

/**
 * Skeleton for a Flink DataStream Job.
 *
 * <p>For a tutorial how to write a Flink application, check the
 * tutorials and examples on the <a href="https://flink.apache.org">Flink Website</a>.
 *
 * <p>To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
public class DataStreamJob {

    public static void main(String[] args) throws Exception {
        // Sets up the execution environment, which is the main entry point
        // to building Flink applications.
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        KafkaSource<String> input = KafkaSource.<String>builder()
            .setBootstrapServers("192.168.3.141:9092")
            .setTopics("flink-input")
            .setGroupId("flink-1")
            .setStartingOffsets(OffsetsInitializer.latest())
            .setValueOnlyDeserializer(new SimpleStringSchema())
            .build();

        Properties props = new Properties();
        props.put("transaction.timeout.ms", 15 * 60 * 1000);

        KafkaSink<String> output = KafkaSink.<String>builder()
            .setBootstrapServers("192.168.3.141:9092")
            .setKafkaProducerConfig(props)
            .setRecordSerializer(
                KafkaRecordSerializationSchema.builder()
                    .setTopic("flink-output")
                    .setValueSerializationSchema(new SimpleStringSchema())
                    .build())
            .setDeliveryGuarantee(DeliveryGuarantee.EXACTLY_ONCE)
            .build();

        DataStream<String> dataStream = env.fromSource(input, WatermarkStrategy.noWatermarks(), "flink-kafka");
        dataStream.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
                @Override
                public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                    String[] split = value.split(" ");
                    for (String word : split) {
                        out.collect(Tuple2.of(word, 1));
                    }
                }
            }).assignTimestampsAndWatermarks(WatermarkStrategy.forBoundedOutOfOrderness(Duration.ofSeconds(1)))
            .keyBy(new KeySelector<Tuple2<String, Integer>, String>() {
                @Override
                public String getKey(Tuple2<String, Integer> value) throws Exception {
                    return value.f0;
                }
            })
            .countWindow(6)
            .evictor(CountEvictor.of(3))
            .process(new ProcessWindowFunction<Tuple2<String, Integer>, Tuple2<String, Integer>, String, GlobalWindow>() {
                @Override
                public void process(String s,
                    ProcessWindowFunction<Tuple2<String, Integer>, Tuple2<String, Integer>, String, GlobalWindow>.Context context,
                    Iterable<Tuple2<String, Integer>> elements,
                    Collector<Tuple2<String, Integer>> out) throws Exception {
                    System.out.println(s);
                    for (Tuple2<String, Integer> element : elements) {
                        System.out.println(element);
                        out.collect(element);
                    }
                }
            })
            // .window(TumblingProcessingTimeWindows.of(Duration.ofSeconds(5)))
            .flatMap(new FlatMapFunction<Tuple2<String, Integer>, String>() {
                @Override
                public void flatMap(Tuple2<String, Integer> value, Collector<String> out) {
                    out.collect(value.f0 + ": " + value.f1);
                }
            }).sinkTo(output);

        env.execute("flink-kafka");
    }
}
