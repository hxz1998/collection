/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example.expression;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class ExpressionStorage {

    private static final Map<String, ExpressionEntity> expressions = new ConcurrentHashMap<>();

    public ExpressionEntity getExpression(String key) {
        return expressions.get(key);
    }

    public void addExpression(String key, ExpressionEntity expression) {
        expressions.put(key, expression);
    }
}
