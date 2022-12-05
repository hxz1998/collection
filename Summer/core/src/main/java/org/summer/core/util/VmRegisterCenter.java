/**
 * Summer
 *
 * @Description: 虚拟机注册中心
 * 把发现的虚拟机注册到这里
 * @Author: cherry
 * @Create on: 2022/6/24
 **/
package org.summer.core.util;

import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.HashMap;
import java.util.Map;

public class VmRegisterCenter {
    private static final Map<String, VirtualMachineDescriptor> pools = new HashMap<>();

    public static void clear() {
        pools.clear();
    }

    public static void add(String key, VirtualMachineDescriptor descriptor) {
        pools.put(key, descriptor);
    }

    public static void remove(String key) {
        pools.remove(key);
    }

    public static VirtualMachineDescriptor get(String key) {
        return pools.get(key);
    }

}
