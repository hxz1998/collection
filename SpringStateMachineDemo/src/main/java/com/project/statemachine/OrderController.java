/**
 * SpringStateMachineDemo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/7/14
 **/
package com.project.statemachine;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderData createOrder(@RequestBody OrderData orderData) {
        return orderService.createOrder(orderData);
    }

    @PostMapping("/{orderId}/process")
    public ResponseEntity<OrderData> processOrder(@PathVariable Long orderId) {
        Optional<OrderData> order = orderService.processOrder(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{orderId}/ship")
    public ResponseEntity<OrderData> shipOrder(@PathVariable Long orderId) {
        Optional<OrderData> order = orderService.shipOrder(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{orderId}/deliver")
    public ResponseEntity<OrderData> deliverOrder(@PathVariable Long orderId) {
        Optional<OrderData> order = orderService.deliverOrder(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<OrderData> cancelOrder(@PathVariable Long orderId) {
        Optional<OrderData> order = orderService.cancelOrder(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
