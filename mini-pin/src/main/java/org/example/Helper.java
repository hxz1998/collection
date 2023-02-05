/**
 * mini-pin
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2022/10/16
 **/
package org.example;

public class Helper {

    /**
     * 不要修改jni-lib的名称
     */
    public final static String JNI_LIBRARY_NAME = "native-helper";

    static {
        System.loadLibrary("native-helper");
    }

    private static synchronized native void forceGc0();

    /**
     * 获取某个class在jvm中当前所有存活实例
     */
    private static synchronized native <T> T[] getInstances0(Class<T> klass, int limit);

    /**
     * 统计某个class在jvm中当前所有存活实例的总占用内存，单位：Byte
     */
    private static synchronized native long sumInstanceSize0(Class<?> klass);

    /**
     * 获取某个实例的占用内存，单位：Byte
     */
    private static native long getInstanceSize0(Object instance);

    /**
     * 统计某个class在jvm中当前所有存活实例的总个数
     */
    private static synchronized native long countInstances0(Class<?> klass);

    /**
     * 获取所有已加载的类
     *
     * @param klass 这个参数必须是 Class.class
     * @return
     */
    private static synchronized native Class<?>[] getAllLoadedClasses0(Class<?> klass);

    public void forceGc() {
        forceGc0();
    }

    public <T> T[] getInstances(Class<T> klass) {
        return getInstances0(klass, -1);
    }

    public <T> T[] getInstances(Class<T> klass, int limit) {
        if (limit == 0) {
            throw new IllegalArgumentException("limit can not be 0");
        }
        return getInstances0(klass, limit);
    }

    public long sumInstanceSize(Class<?> klass) {
        return sumInstanceSize0(klass);
    }

    public long getInstanceSize(Object instance) {
        return getInstanceSize0(instance);
    }

    public long countInstances(Class<?> klass) {
        return countInstances0(klass);
    }

    public Class<?>[] getAllLoadedClasses() {
        return getAllLoadedClasses0(Class.class);
    }

    public boolean allocateMemory(long size) {
        return allocateMemory0(size);
    }

    private static native boolean allocateMemory0(long size);

    public void suspendThread(Thread thread) {
        suspendThread0(thread);
    }

    private static native void suspendThread0(Thread thread);
}
