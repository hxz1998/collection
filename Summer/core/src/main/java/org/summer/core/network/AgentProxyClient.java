/**
 * Summer
 *
 * @Description: 用于双方通信时提供的客户端代理
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

@Slf4j
public class AgentProxyClient {
    private final String host;
    private final int port;

    private final Kryo serializer;

    public AgentProxyClient(String host, int port) {
        this.host = host;
        this.port = port;
        serializer = new Kryo();
        serializer.register(Response.class);
        serializer.register(Request.class);
        serializer.register(RequestType.class);
        serializer.register(ResponseType.class);
        serializer.register(Class.class);
        serializer.register(LinkedList.class);
        serializer.register(ModifyEntity.class);
    }

    public <T> T send(Request request, Class<T> type) {
        try (Socket socket = new Socket(host, port)) {
            log.debug("发送请求" + request.getType());
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            Output output = new Output(bos);
            serializer.writeObject(output, request);
            output.flush();
            log.debug("发送完成");

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            Input input = new Input(bis);
            Response response = serializer.readObject(input, Response.class);
            log.debug("收到响应" + response.getMsg());
            input.close();
            bis.close();
            output.close();
            return type.cast(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
