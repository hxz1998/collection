/**
 * JCToolTest
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/8/9
 **/
package org.example;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisruptorTest {

    public static void main(String[] args) throws InterruptedException {
        Disruptor<OrderEvent> queue = new Disruptor<>(
            new OrderEventFactory(),
            1024,
            Executors.newFixedThreadPool(10),
            ProducerType.MULTI,
            new YieldingWaitStrategy()
        );
        queue.handleEventsWith(new OrderEventConsumer());
        queue.start();
        RingBuffer<OrderEvent> buffer = queue.getRingBuffer();
        OrderProducer producer = new OrderProducer(buffer);
        while (true) {
            producer.onData();
        }
    }

}

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
class OrderEvent {

    private String name;
    private int id;
}

@Slf4j
class OrderEventConsumer implements EventHandler<OrderEvent>, WorkHandler<OrderEvent> {

    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
        log.info("Event: {}, sequence: {}, endOfBatch: {}", event, sequence, endOfBatch);
    }

    @Override
    public void onEvent(OrderEvent event) throws Exception {
        log.info("Event: {}", event);
    }
}

@Slf4j
class OrderEventFactory implements EventFactory<OrderEvent> {

    private static final AtomicInteger idGen = new AtomicInteger(0);

    @Override
    public OrderEvent newInstance() {
        log.info("生产了一个对象：{}", idGen.get());
        return new OrderEvent(UUID.randomUUID().toString(), idGen.getAndIncrement());
    }
}

@Slf4j
class OrderProducer {

    private final RingBuffer<OrderEvent> ringBuffer;

    public OrderProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件事件
     * 它的参数会通过事件传递给消费者
     */
    public void onData() {

        // step1：通过从 环形队列中 获取 序号
        //可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
        long sequence = ringBuffer.next();

        try {

            //step2: 通过序号获取 对应的 事件对象， 将数据填充到 事件对象，
            //用上面的索引，取出一个空的事件用于填充
            OrderEvent event = ringBuffer.get(sequence);// for the sequence
            log.info("onData: {}", event);
        } finally {
            //step3: 再通过 序号将 事件对象 发布出去。
            //发布事件
            ringBuffer.publish(sequence);
        }
    }
}