/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventType {
    EXPRESSION("EXPRESSION"),
    CLASS_BODY("CLASS_BODY"),
    COMPILE("COMPILE");

    private final String desc;
}
