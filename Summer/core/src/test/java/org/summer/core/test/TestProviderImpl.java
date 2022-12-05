/**
 * Summer
 *
 * @Description: 测试数据提供者
 * @Author: cherry
 * @Create on: 2022/6/23
 **/
package org.summer.core.test;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachineDescriptor;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.common.MXBeanType;
import org.summer.core.exception.AttachCurrentVMException;
import org.summer.core.exception.VirtualMachineUnsupported;
import org.summer.core.monitor.view.ProviderImpl;
import org.summer.core.util.VirtualMachineHelper;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class TestProviderImpl {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, VirtualMachineUnsupported, AttachCurrentVMException {
        List<VirtualMachineDescriptor> virtualMachineDescriptors = VirtualMachineHelper.list();
        log.debug("一共有 " + virtualMachineDescriptors.size() + " 台虚拟机：");
        for (VirtualMachineDescriptor descriptor : virtualMachineDescriptors) {
            log.debug(descriptor.id() + " + " + descriptor.displayName());
        }
        ProviderImpl provider = new ProviderImpl();
        provider.inject(VirtualMachineHelper.attach(new Scanner(System.in).next()));
        List<MXBeanType> supportedList = provider.list();
        log.debug("一共支持 " + supportedList.size() + " 个监控对象");
    }
}
