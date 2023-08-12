/**
 * JCToolTest
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/8/9
 **/
package org.example;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.UUID;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DisruptorTest2 {
    public static void main(String[] args) throws InterruptedException {
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
            OrderEvent::new,
            1024 * 1024,
            Executors.defaultThreadFactory(),
            ProducerType.SINGLE,
            new YieldingWaitStrategy()
        );
        disruptor.handleEventsWith(new OrderEventHandler2());
        disruptor.start();
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer2 eventProducer = new OrderEventProducer2(ringBuffer);
        eventProducer.onData(2);
    }
}

class OrderEventProducer2 {

    private final RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer2(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(int orderId) {
        long sequence = ringBuffer.next();
        try {
            OrderEvent orderEvent = ringBuffer.get(sequence);
            orderEvent.setId(orderId);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

@Slf4j
class OrderEventHandler2 implements EventHandler<OrderEvent>, WorkHandler<OrderEvent> {

    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
        log.info("event: {}, sequence: {}, endOfBatch: {}", event, sequence, endOfBatch);
    }

    @Override
    public void onEvent(OrderEvent event) {
        log.info("event: {}", event);
    }
}