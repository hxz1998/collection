/**
 * flink-kafka
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/12/8
 **/
package org.example;


import com.google.gson.Gson;
import java.time.Duration;
import java.util.Properties;
import lombok.Data;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.util.Collector;

public class WindowsJoin {

    private static final Gson gson = new Gson();

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        KafkaSource<String> input1 = KafkaSource.<String>builder()
            .setBootstrapServers("192.168.3.141:9092")
            .setTopics("flink-input-1")
            .setGroupId("flink-1")
            .setStartingOffsets(OffsetsInitializer.latest())
            .setValueOnlyDeserializer(new SimpleStringSchema())
            .build();
        KafkaSource<String> input2 = KafkaSource.<String>builder()
            .setBootstrapServers("192.168.3.141:9092")
            .setTopics("flink-input-2")
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
                    .setTopic("flink-windows-join-output")
                    .setValueSerializationSchema(new SimpleStringSchema())
                    .build()
            )
            .setDeliveryGuarantee(DeliveryGuarantee.EXACTLY_ONCE)
            .build();

        DataStream<String> stream1 = env.fromSource(input1, WatermarkStrategy.noWatermarks(), "input1");
        DataStream<String> stream2 = env.fromSource(input2, WatermarkStrategy.noWatermarks(), "input2");
        stream1.join(stream2).where(new KeySelector<String, String>() {
                @Override
                public String getKey(String value) throws Exception {
                    Record record = gson.fromJson(value, Record.class);
                    return record.getId();
                }
            }).equalTo(new KeySelector<String, String>() {
                @Override
                public String getKey(String value) throws Exception {
                    Record record = gson.fromJson(value, Record.class);
                    return record.getId();
                }
            }).window(TumblingProcessingTimeWindows.of(Duration.ofSeconds(5)))
            .apply(new FlatJoinFunction<String, String, String>() {
                @Override
                public void join(String first, String second, Collector<String> out) throws Exception {
                    Record record1 = gson.fromJson(first, Record.class);
                    Record record2 = gson.fromJson(second, Record.class);
                    record1.setValue(record1.getValue() + ":" + record2.getValue());
                    String result = gson.toJson(record1);
                    out.collect(result);
                }
            })
            .sinkTo(output);

        env.execute("windows-join-flink");

    }
}

@Data
class Record {

    private String id;
    private String value;
}
