/**
 * SimpleWorkflowEngine
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/22
 **/
package org.example.workflow.engine.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.workflow.engine.Data;
import org.example.workflow.engine.Process;

@Slf4j
public class PrintProcess<T> implements Process<T> {

    @Override
    public Data<T> onExecute(Data<T> data) {
        log.info("Print: {}", data.getValue());
        return data;
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
