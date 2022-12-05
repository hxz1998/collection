/**
 * Summer
 *
 * @Description: 测试客户端代理
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.test;

import org.summer.core.network.AgentProxyClient;
import org.summer.core.network.Request;
import org.summer.core.network.RequestType;
import org.summer.core.network.Response;

import java.io.IOException;
import java.util.LinkedList;

public class TestAgentClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        AgentProxyClient client = new AgentProxyClient("127.0.0.1", 8888);
        Response<LinkedList<String>> list = client.send(new Request(RequestType.LIST_CLASSES, "org.summer"), Response.class);
        for (String clazz : list.getValue()) {
            System.out.println(clazz);
        }
        Response<String> content = client.send(new Request<String>(RequestType.GET_CLASS_CONTENT, list.getValue().get(0)), Response.class);
        System.out.println(content.getValue());
    }
}
