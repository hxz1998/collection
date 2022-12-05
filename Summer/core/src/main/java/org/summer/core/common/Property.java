/**
 * Summer
 *
 * @Description: 属性实体类
 * @Author: cherry
 * @Create on: 2022/6/27
 **/
package org.summer.core.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Property {
    private String key;
    private String value;

    public Property(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
