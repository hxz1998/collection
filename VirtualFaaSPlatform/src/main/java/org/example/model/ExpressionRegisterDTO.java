/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/8
 **/
package org.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class ExpressionRegisterDTO {

    @ApiModelProperty(value = "表达式的 key", example = "add")
    private String key;
    @ApiModelProperty(value = "表达式", example = "a + b")
    private String expression;
    @ApiModelProperty(value = "参数名", example = "a,b")
    private String parameterNames;
    @ApiModelProperty(value = "参数类型", example = "java.lang.Integer,java.lang.Integer")
    private String parameterTypes;
    @ApiModelProperty(value = "表达式返回类型", example = "java.lang.Integer")
    private String expressionType;
}
