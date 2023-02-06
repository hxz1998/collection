/**
 * explore
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/9/30
 **/
package com.example.explore.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello() {
        return "I am Spring Application.";
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {

        return name + " good luck.";
    }
}
