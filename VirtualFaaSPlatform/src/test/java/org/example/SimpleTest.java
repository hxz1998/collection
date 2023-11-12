/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.InvocationTargetException;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;
import org.example.expression.ExpressionData;
import org.example.expression.ExpressionEntity;
import org.example.model.Event;
import org.example.model.EventType;
import org.example.util.ClassTypeAdapter;
import org.example.util.GsonUtil;

public class SimpleTest {

    private static final Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Class.class, new ClassTypeAdapter());
        gson = gsonBuilder.create();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Integer integer = Integer.getInteger("1");
        System.out.println(Integer.class.getMethod("valueOf", String.class).invoke(null, "20"));
        Class<?> clazz = Class.forName("java.lang.Integer");
        String expressinString = gson.toJson(new ExpressionEntity("", "a % b", new String[]{"a", "b"}, new Class<?>[]{Integer.class, Integer.class}, Integer.class));
        System.out.println(expressinString);
        ExpressionEntity entity = gson.fromJson(expressinString, ExpressionEntity.class);
        System.out.println(entity);
        try {
            ExpressionEvaluator ee = new ExpressionEvaluator(
                entity.getExpression(),
                entity.getExpressionType(),
                entity.getParameterName(),
                entity.getParameterTypes()
            );
            System.out.println(ee.evaluate(new Integer[]{1, 2}));
        } catch (CompileException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        Event event = new Event();
        event.setEventType(EventType.EXPRESSION);

        System.out.println(GsonUtil.toJson(event));

        ExpressionData expressionData = new ExpressionData();
        expressionData.setContent("1,2");
        expressionData.setKey("add");
        System.out.println(GsonUtil.toJson(expressionData));
    }
}
