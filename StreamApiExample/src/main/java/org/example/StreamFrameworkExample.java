/**
 * StreamApiExample
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/9/27
 **/
package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// 自定义流处理框架
class MyStream<T> {

    private List<T> data;

    private MyStream(List<T> inputData) {
        this.data = new ArrayList<>(inputData);
    }

    public static <T> MyStream<T> of(List<T> inputData) {
        return new MyStream<>(inputData);
    }

    public MyStream<T> filter(Predicate<T> predicate) {
        List<T> filteredData = new ArrayList<>();
        for (T element : data) {
            if (predicate.test(element)) {
                filteredData.add(element);
            }
        }
        data = filteredData;
        return this;
    }

    public <R> MyStream<R> map(Function<T, R> mapper) {
        List<R> mappedData = new ArrayList<>();
        for (T element : data) {
            mappedData.add(mapper.apply(element));
        }
        return new MyStream<>(mappedData);
    }

    public void forEach(Consumer<T> action) {
        for (T element : data) {
            action.accept(element);
        }
    }

    public List<T> collect() {
        return new ArrayList<>(data);
    }
}

public class StreamFrameworkExample {

    public static void main(String[] args) {
        // 构建输入数据
        List<Integer> inputData = new ArrayList<>();
        inputData.add(1);
        inputData.add(2);
        inputData.add(3);
        // 构建流处理链
        MyStream<Integer> stream = MyStream.of(inputData)
            .filter(n -> n % 2 == 0) // 过滤算子
            .map(n -> n * 2); // 替换算子

        List<Integer> results = stream.collect();

        // 输出结果
        System.out.println(results); // 输出: [4, 8]
    }
}
