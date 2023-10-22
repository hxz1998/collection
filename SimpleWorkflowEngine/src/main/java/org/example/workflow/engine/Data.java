/**
 * SimpleWorkflowEngine
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/10/21
 **/
package org.example.workflow.engine;

import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
public class Data<T> {

    private T value;
}
