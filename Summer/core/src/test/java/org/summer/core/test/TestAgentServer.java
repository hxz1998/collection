/**
 * Summer
 *
 * @Description: 测试服务端代理
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.test;

import com.sun.tools.attach.*;
import org.summer.core.exception.AttachCurrentVMException;
import org.summer.core.util.VirtualMachineHelper;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestAgentServer {
    public static void main(String[] args) throws AttachCurrentVMException, IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        List<VirtualMachineDescriptor> descriptors = VirtualMachine.list();
        System.out.println("一共有： " + descriptors.size() + " 台虚拟机");
        for (VirtualMachineDescriptor descriptor : descriptors) {
            System.out.println(descriptor.id() + "\t" + descriptor.displayName());
        }
        System.out.print("监控哪一台虚拟机？ > ");
        System.out.println("输入进程 ID");
        HotSpotVirtualMachine machine = VirtualMachineHelper.attach(new Scanner(System.in).next());
        machine.loadAgent("D:\\source\\Java\\Summer\\core\\target\\core-1.0-SNAPSHOT.jar");
    }
}
