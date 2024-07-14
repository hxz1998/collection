/**
 * SpringStateMachineDemo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/7/14
 **/
package com.project.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachineFactory
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) throws Exception {
        states
            .withStates()
            .initial(OrderStates.NEW)
            .state(OrderStates.PROCESSING)
            .state(OrderStates.SHIPPED)
            .state(OrderStates.DELIVERED)
            .state(OrderStates.CANCELED);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions) throws Exception {
        transitions
            .withExternal()
            .source(OrderStates.NEW).target(OrderStates.PROCESSING).event(OrderEvents.PROCESS)
            .and()
            .withExternal()
            .source(OrderStates.PROCESSING).target(OrderStates.SHIPPED).event(OrderEvents.SHIP)
            .and()
            .withExternal()
            .source(OrderStates.SHIPPED).target(OrderStates.DELIVERED).event(OrderEvents.DELIVER)
            .and()
            .withExternal()
            .source(OrderStates.NEW).target(OrderStates.CANCELED).event(OrderEvents.CANCEL)
            .and()
            .withExternal()
            .source(OrderStates.PROCESSING).target(OrderStates.CANCELED).event(OrderEvents.CANCEL);
    }
}