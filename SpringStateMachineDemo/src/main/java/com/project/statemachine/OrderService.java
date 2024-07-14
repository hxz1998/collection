/**
 * SpringStateMachineDemo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/7/14
 **/
package com.project.statemachine;

import java.util.Optional;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory;

    public OrderService(OrderRepository orderRepository, StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory) {
        this.orderRepository = orderRepository;
        this.stateMachineFactory = stateMachineFactory;
    }

    public OrderData createOrder(OrderData orderData) {
        orderData.setState(OrderStates.NEW);
        return orderRepository.save(orderData);
    }

    public Optional<OrderData> processOrder(Long orderId) {
        return changeOrderState(orderId, OrderEvents.PROCESS);
    }

    public Optional<OrderData> shipOrder(Long orderId) {
        return changeOrderState(orderId, OrderEvents.SHIP);
    }

    public Optional<OrderData> deliverOrder(Long orderId) {
        return changeOrderState(orderId, OrderEvents.DELIVER);
    }

    public Optional<OrderData> cancelOrder(Long orderId) {
        return changeOrderState(orderId, OrderEvents.CANCEL);
    }

    private Optional<OrderData> changeOrderState(Long orderId, OrderEvents event) {
        Optional<OrderData> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            OrderData orderData = orderOptional.get();
            StateMachine<OrderStates, OrderEvents> stateMachine = stateMachineFactory.getStateMachine();
            stateMachine.start();
            stateMachine.sendEvent(event);
            orderData.setState(stateMachine.getState().getId());
            orderRepository.save(orderData);
            return Optional.of(orderData);
        }
        return Optional.empty();
    }
}
