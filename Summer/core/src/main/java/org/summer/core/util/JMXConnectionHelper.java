/**
 * Summer
 *
 * @Description: JMX通信连接器辅助类
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.util;

import com.sun.tools.attach.VirtualMachine;
import lombok.extern.slf4j.Slf4j;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class JMXConnectionHelper {
    private static final List<JMXConnector> connectors = new LinkedList<>();

    public static MBeanServerConnection getConnection(String agentURL) throws IOException {
        JMXServiceURL jmxServiceURL = new JMXServiceURL(agentURL);
        JMXConnector connector = JMXConnectorFactory.connect(jmxServiceURL);
        connectors.add(connector);
        return connector.getMBeanServerConnection();
    }

    public static MBeanServerConnection getConnection(VirtualMachine vmd) throws IOException {
        return getConnection(vmd.startLocalManagementAgent());
    }

    public static void closeAll() {
        for (JMXConnector connector : connectors) {
            try {
                connector.close();
            } catch (IOException e) {
                log.error("关闭 JMXConnector 时出错");
            }
        }
    }

}
