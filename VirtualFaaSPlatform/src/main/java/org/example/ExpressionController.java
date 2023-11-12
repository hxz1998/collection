/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import org.example.engine.Engine;
import org.example.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "表达式管理")
@RestController
@RequestMapping("/expr")
@Setter(onMethod_ = {@Autowired})
public class ExpressionController {

    @Qualifier("expressionEngine")
    private Engine engine;

    @ApiOperation(value = "注册表达式", notes = "注册一个函数放到服务器上")
    @PostMapping("/register")
    public String register(@RequestBody Event event) {
        engine.register(event, null);
        return "SUCCESS";
    }

    @PostMapping("/evaluate")
    public String evaluate(@RequestBody Event event) {
        return engine.handle(event, null);
    }
}
