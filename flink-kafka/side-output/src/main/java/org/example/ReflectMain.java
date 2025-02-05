/**
 * flink-kafka
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2025/1/3
 **/
package org.example;

import java.lang.reflect.Method;

public class ReflectMain {

    public static void main(String[] args) {
        B b = new B();
        Method[] methods = b.getClass().getMethods();
        System.out.println();
    }
}

class A {
    private String a;
    private String aa;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getAA() {
        return aa;
    }

    public void setAA(String aa) {
        this.aa = aa;
    }
}

class B extends A {
    private String b;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
