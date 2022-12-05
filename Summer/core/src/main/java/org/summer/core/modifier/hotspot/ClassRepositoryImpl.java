/**
 * Summer
 *
 * @Description: 类仓库实现类
 * @Author: cherry
 * @Create on: 2022/6/26
 **/
package org.summer.core.modifier.hotspot;

import javassist.CtClass;
import lombok.extern.slf4j.Slf4j;
import org.summer.core.modifier.ClassRepository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ClassRepositoryImpl implements ClassRepository {

    private final Map<String, CtClass> mapper;
    private final Map<String, byte[]> classBytesMapper;
    private final Map<String, Class<?>> classMap;

    public ClassRepositoryImpl() {
        mapper = new HashMap<>();
        classBytesMapper = new HashMap<>();
        classMap = new HashMap<>();
    }

    @Override
    public boolean exists(String name) {
        return mapper.containsKey(name);
    }

    @Override
    public boolean exists(CtClass ctClass) {
        return mapper.containsKey(ctClass.getName());
    }

    @Override
    public void put(String name, CtClass ctClass, byte[] bytecode) {
        mapper.put(name, ctClass);
        classBytesMapper.put(name, bytecode);
    }

    @Override
    public void remove(String name) {
        mapper.remove(name);
    }

    @Override
    public CtClass getCtClass(String name) {
        return mapper.get(name);
    }

    @Override
    public byte[] getBytes(String name) {
        return classBytesMapper.get(name);
    }

    @Override
    public Class<?> getClazz(String name) {
        return classMap.get(name);
    }

    @Override
    public void put(String name, Class<?> clazz) {
        classMap.put(name, clazz);
    }


}
