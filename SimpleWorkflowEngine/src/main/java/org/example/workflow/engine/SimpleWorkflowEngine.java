/**
 * SimpleWorkflowEngine
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/21
 **/
package org.example.workflow.engine;

import java.util.HashMap;
import java.util.Map;

public class SimpleWorkflowEngine<T> {

    private final Map<String, Process<T>> workflows = new HashMap<>();

    public void addWorkflow(String processingName, Process<T> process) {
        workflows.put(processingName, process);
    }


    public Data<T> execute(String[] steps, Data<T> data) {
        for (String step : steps) {
            if (workflows.containsKey(step)) {
                Process<T> process = workflows.get(step);
                process.onExecute(data);
            } else {
                throw new RuntimeException("没有支持的流程");
            }
        }
        return data;
    }
}
