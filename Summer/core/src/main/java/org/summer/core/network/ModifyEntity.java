/**
 * Summer
 *
 * @Description: 用于传输的实体类
 * 用于表示要修改的类、方法、和具体内容
 * @Author: cherry
 * @Create on: 2022/7/10
 **/
package org.summer.core.network;

import lombok.Getter;

@Getter
public class ModifyEntity {

    private String label;
    private String code;

    public ModifyEntity() {
    }

    public ModifyEntity(String label, String code) {
        this.label = label;
        this.code = code;
    }
}
