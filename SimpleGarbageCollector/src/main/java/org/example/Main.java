package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GarbageCollector gc = new GarbageCollector();

        // 创建一些对象并加入到垃圾回收器中
        GarbageObject obj1 = new GarbageObject("obj1");
        GarbageObject obj2 = new GarbageObject("obj2");
        GarbageObject obj3 = new GarbageObject("obj3");

        obj1.setReference(obj2); // obj1 引用 obj2
        obj2.setReference(obj3); // obj2 引用 obj3

        gc.addObject(obj1);
        gc.addObject(obj2);
        gc.addObject(obj3);

        // 第一次垃圾回收
        gc.mark();
        gc.sweep();

        // 输出剩余对象列表，只剩下 obj3
        System.out.println(gc.getObjects());

        // 创建另一个对象，并引用 obj3
        GarbageObject obj4 = new GarbageObject("obj4");
        obj4.setReference(obj3);

        gc.addObject(obj4);

        // 第二次垃圾回收
        gc.mark();
        gc.sweep();

        // 输出剩余对象列表，只剩下 obj3 和 obj4
        System.out.println(gc.getObjects());
    }

}

class GarbageCollector {

    private List<Object> objects = new LinkedList<>(); // 对象列表

    public List<Object> getObjects() {
        return objects;
    }

    public void addObject(Object object) {
        objects.add(object); // 将对象添加到对象列表中
    }

    public void mark() {
        for (Object object : objects) {
            mark(object); // 遍历对象列表，标记所有可达对象
        }
    }

    private void mark(Object object) {
        if (object == null) return; // 如果对象为空，直接返回

        // 标记对象为存活
        ((GarbageObject) object).setAlive(true);

        // 遍历访问对象的引用域，并标记所有可达对象
        for (Object ref : ((GarbageObject) object).getReferences()) {
            if (!((GarbageObject) ref).isAlive()) {
                mark(ref);
            }
        }
    }

    public void sweep() {
        Iterator<Object> iter = objects.iterator();

        while (iter.hasNext()) {
            Object object = iter.next();
            if (!((GarbageObject) object).isAlive()) {
                // 如果对象是垃圾对象，从对象列表中移除对象
                iter.remove();
            } else {
                // 否则重新将对象标记为未存活状态，以便下一次垃圾回收时重新标记
                ((GarbageObject) object).setAlive(false);
            }
        }
    }
}

class GarbageObject {
    private String name;
    private boolean alive = false;
    private List<Object> references = new LinkedList<>();

    public GarbageObject(String name) {
        this.name = name;
    }

    public void setReference(Object ref) {
        references.add(ref);
    }

    public List<Object> getReferences() {
        return references;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "GarbageObject{" +
                "name='" + name + '\'' +
                '}';
    }
}