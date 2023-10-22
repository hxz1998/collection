/**
 * SimpleWorkflowEngine
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/22
 **/
package org.example.workflow.engine.impl;

import org.example.workflow.engine.Data;
import org.example.workflow.engine.Process;

public class IntegerIncreaseProcess implements Process<Integer> {

    @Override
    public Data<Integer> onExecute(Data<Integer> data) {
        data.setValue(data.getValue() + 1);
        return data;
    }

    @Override
    public boolean isFinal() {
        return false;
    }
}
