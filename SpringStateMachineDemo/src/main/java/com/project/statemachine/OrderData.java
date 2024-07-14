/**
 * SpringStateMachineDemo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2024/7/14
 **/
package com.project.statemachine;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class OrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStates state;

    private Date createDate;

    private String owner;
}
