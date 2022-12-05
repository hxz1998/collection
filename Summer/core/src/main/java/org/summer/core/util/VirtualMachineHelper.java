/**
 * Summer
 *
 * @Description: 虚拟机帮助类
 * 主要提供如下方法：
 * 1. 连接
 * 2. 发现虚拟机列表
 * @Author: cherry
 * @Create on: 2022/6/22
 **/
package org.summer.core.util;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.summer.core.exception.AttachCurrentVMException;
import sun.tools.attach.HotSpotVirtualMachine;

import java.io.IOException;
import java.util.List;

public class VirtualMachineHelper {

    public static List<VirtualMachineDescriptor> list() {
        return VirtualMachine.list();
    }

    public static HotSpotVirtualMachine attach(String jid) throws IOException, AttachNotSupportedException, AttachCurrentVMException {
        if (jid.equals(String.valueOf(ProcessHandle.current().pid()))) throw new AttachCurrentVMException();
        return (HotSpotVirtualMachine) VirtualMachine.attach(jid);
    }

    public static HotSpotVirtualMachine attach(VirtualMachineDescriptor vmd) throws IOException, AttachNotSupportedException, AttachCurrentVMException {
        return attach(vmd.id());
    }
}
