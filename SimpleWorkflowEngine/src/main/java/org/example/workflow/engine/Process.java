/**
 * SimpleWorkflowEngine
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/21
 **/
package org.example.workflow.engine;

public interface Process<T> {

    Data<T> onExecute(Data<T> data);

    boolean isFinal();
}
