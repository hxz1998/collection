/**
 * flink-kafka
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/12/9
 **/
package org.example;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

public class SideOutputPlayground {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        final OutputTag<String> oddTag = new OutputTag<String>("odd") {
        };
        final OutputTag<String> evenTag = new OutputTag<String>("even") {
        };

        DataStream<Integer> input = env.fromData(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        SingleOutputStreamOperator<Integer> passThroughStream = input.process(new ProcessFunction<Integer, Integer>() {

            @Override
            public void processElement(Integer value,
                ProcessFunction<Integer, Integer>.Context ctx,
                Collector<Integer> out) throws Exception {
                out.collect(value);
                if (value % 2 == 0) {
                    ctx.output(evenTag, "even-side - " + value);
                } else {
                    ctx.output(oddTag, "odd-side - " + value);
                }
            }
        });

        passThroughStream.print();
        passThroughStream.getSideOutput(oddTag).print();
        passThroughStream.getSideOutput(evenTag).print();

        env.execute("Side Output Example");
        System.out.println();
    }
}
