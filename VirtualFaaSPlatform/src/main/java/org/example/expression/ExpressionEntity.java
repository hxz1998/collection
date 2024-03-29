/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example.expression;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@ApiModel
public class ExpressionEntity {

    @ApiModelProperty(value = "表达式的 key", example = "add")
    private String key;
    @ApiModelProperty(value = "表达式", example = "a + b")
    private String expression;
    @ApiModelProperty(value = "参数名", example = "a,b")
    private String[] parameterName;
    @ApiModelProperty(value = "参数类型", example = "java.lang.Integer,java.lang.Integer")
    private Class<?>[] parameterTypes;
    @ApiModelProperty(value = "表达式返回类型", example = "java.lang.Integer")
    private Class<?> expressionType;
}
