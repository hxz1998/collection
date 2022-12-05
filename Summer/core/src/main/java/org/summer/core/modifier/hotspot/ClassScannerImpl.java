/**
 * Summer
 *
 * @Description: 类扫描实现类
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.modifier.hotspot;

import lombok.extern.slf4j.Slf4j;
import org.summer.core.modifier.ClassScanner;

import java.lang.instrument.Instrumentation;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ClassScannerImpl implements ClassScanner {

    private final Instrumentation instrumentation;

    public ClassScannerImpl(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    @Override
    public Class<?>[] listAllLoadedClass() {
        return listAllLoadedClass(this.instrumentation);
    }

    @Override
    public Class<?>[] listAllLoadedClass(String prefix) {
        return listAllLoadedClass(this.instrumentation, prefix);
    }

    @Override
    public Class<?>[] listAllLoadedClass(Instrumentation instrumentation) {
        return instrumentation.getAllLoadedClasses();
    }

    @Override
    public Class<?>[] listAllLoadedClass(Instrumentation instrumentation, String prefix) {
        List<Class<?>> list = new LinkedList<>();
        for (Class<?> clazz : listAllLoadedClass(instrumentation)) {
            if (clazz.getName().startsWith(prefix))
                list.add(clazz);
        }
        return (Class<?>[]) list.toArray();
    }
}
