/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/5
 **/
package org.example;

import java.io.StringReader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.commons.compiler.CompilerFactoryFactory;
import org.codehaus.commons.compiler.IClassBodyEvaluator;
import org.example.function.BaseFunction;
import org.springframework.stereotype.Component;

@Component("engine")
public class VirtualFaaSEngine {

    public <R, T> R exec(String code, T param) {
        Worker<R, T> worker = new Worker<>();
        worker.setCode(code);
        worker.setInput(param);
        // Thread.startVirtualThread(worker);
        return null;
    }
}

@Setter
@Getter
@NoArgsConstructor
class Worker<R, T> implements Runnable {

    private String code;
    private T input;
    private R output;
    private boolean ready = false;

    @Override
    public void run() {
        IClassBodyEvaluator cbe = null;
        try {
            cbe = CompilerFactoryFactory.getDefaultCompilerFactory().newClassBodyEvaluator();
            cbe.setImplementedInterfaces(new Class[]{BaseFunction.class});
            Object proxy = cbe.createInstance(new StringReader(code));
            if (proxy instanceof BaseFunction<?, ?>) {
                output = ((BaseFunction<R, T>) proxy).invoke(input);
            }
            ready = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
