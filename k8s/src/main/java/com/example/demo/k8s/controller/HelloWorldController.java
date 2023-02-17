/**
 * k8s
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/11/9
 **/
package com.example.demo.k8s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@RestController
public class HelloWorldController {
    private static final String ID;

    static {
        ID = UUID.randomUUID().toString();
    }

    @GetMapping("/")
    public String helloWorld() throws UnknownHostException {
        String username = System.getProperty("user.name");
        String hostname = InetAddress.getLocalHost().getHostName();
        return "ID: " + ID + " hello, world!, properties: " + username + "@" + hostname;
    }
}
