/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example;

import java.lang.reflect.InvocationTargetException;
import lombok.Setter;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;
import org.example.engine.Engine;
import org.example.expression.ExpressionData;
import org.example.expression.ExpressionEntity;
import org.example.expression.ExpressionStorage;
import org.example.model.Event;
import org.example.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(onMethod_ = {@Autowired})
public class ExpressionEngine implements Engine {

    private ExpressionStorage expressionStorage;

    @Override
    public String handle(Event event, Context context) {
        ExpressionData expressionData = GsonUtil.covert(event.getData(), ExpressionData.class);
        ExpressionEntity expressionEntity = expressionStorage.getExpression(expressionData.getKey());
        String ret;
        try {
            ExpressionEvaluator ee = new ExpressionEvaluator(
                expressionEntity.getExpression(),
                expressionEntity.getExpressionType(),
                expressionEntity.getParameterName(),
                expressionEntity.getParameterTypes()
            );
            ret = ee.evaluate(getParameterValues(expressionData.getContent(), expressionEntity.getParameterTypes())).toString();
        } catch (CompileException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    private Object[] getParameterValues(String content, Class<?>[] parameterTypes) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object[] objects = new Object[parameterTypes.length];
        String[] parameters = content.split(",");
        for (int idx = 0; idx < objects.length; ++idx) {
            objects[idx] = parameterTypes[idx].getMethod("valueOf", String.class).invoke(null, parameters[idx]);
        }
        return objects;
    }
}
