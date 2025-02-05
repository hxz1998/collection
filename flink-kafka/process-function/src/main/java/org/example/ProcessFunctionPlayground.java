/**
 * flink-kafka
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/12/8
 **/
package org.example;

import lombok.Data;
import org.apache.flink.api.common.functions.OpenContext;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

public class ProcessFunctionPlayground {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.fromData(new Tuple2<String, String>("hello", "hello"),
                new Tuple2<String, String>("world", "world"),
                new Tuple2<String, String>("hello", "hello"),
                new Tuple2<String, String>("hello", "hello"),
                new Tuple2<String, String>("hello", "hello"))
            .keyBy(new KeySelector<Tuple2<String, String>, String>() {
                @Override
                public String getKey(Tuple2<String, String> value) throws Exception {
                    return value.f0;
                }
            })
            .process(new KeyFunctionImpl())
            .print();
        env.execute("process-function");
    }
}

class KeyFunctionImpl extends KeyedProcessFunction<String, Tuple2<String, String>, Tuple2<String, Long>> {


    private ValueState<CountWithTimestamp> state;

    @Override
    public void open(OpenContext openContext) throws Exception {
        state = getRuntimeContext().getState(
            new ValueStateDescriptor<CountWithTimestamp>("mystate", CountWithTimestamp.class)
        );
    }

    @Override
    public void onTimer(long timestamp, KeyedProcessFunction<String, Tuple2<String, String>, Tuple2<String, Long>>.OnTimerContext ctx, Collector<Tuple2<String, Long>> out) throws Exception {
        CountWithTimestamp count = state.value();
        if (timestamp == count.getLastModified() + 100) {
            out.collect(new Tuple2<String, Long>(count.getKey(), count.getCount()));
        }
        state.clear();
    }

    @Override
    public void processElement(Tuple2<String, String> value, KeyedProcessFunction<String, Tuple2<String, String>, Tuple2<String, Long>>.Context ctx, Collector<Tuple2<String, Long>> out) throws Exception {
        CountWithTimestamp count = state.value();
        if (count == null) {
            count = new CountWithTimestamp();
            count.setKey(value.f0);
        }
        count.setCount(count.getCount() + 1);
        count.setLastModified(ctx.timestamp());
        state.update(count);
        ctx.timerService().registerEventTimeTimer(count.getLastModified() + 100);
    }
}



@Data
class CountWithTimestamp {

    private String key;
    private long count;
    private long lastModified;
}
