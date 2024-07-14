/**
 * SpringStateMachineDemo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/7/14
 **/
package com.project.statemachine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderData, Long> {

}
