/**
 * Summer
 *
 * @Description: 代理类加载入口
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.agent;

import lombok.extern.slf4j.Slf4j;
import org.summer.core.network.AgentProxyServer;

import java.lang.instrument.Instrumentation;


@Slf4j
public class ModifierAgentMain {

    public static void agentmain(String agentArgs, Instrumentation inst) {
        log.debug("Modifier Agent loaded... " + agentArgs);
        AgentProxyServer server = new AgentProxyServer(8888, inst);
        server.start();
    }

    public static void agentmain(String agentArgs) {

    }
}
