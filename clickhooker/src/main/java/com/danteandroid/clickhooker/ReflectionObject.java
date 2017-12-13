package com.danteandroid.clickhooker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yons on 17/12/13.
 */

public class ReflectionObject {
    Object object;
    String className;
    Class<?> aClass;

    private ReflectionObject(Object object, String className) {
        this.object = object;
        this.className = className;
        try {
            aClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ReflectionObject toReflection(Object o, String className) {
        return new ReflectionObject(o, className);
    }

    @SuppressWarnings("unchecked")
    public <T> T field(String field) {
        try {
            Field f = aClass.getDeclaredField(field);
            f.setAccessible(true);
            return (T) f.get(object);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void setField(String field, Object replaceField) {
        try {
            Field f = aClass.getDeclaredField(field);
            f.setAccessible(true);
            f.set(object, replaceField);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T method(String method) {
        try {
            Method m = aClass.getDeclaredMethod(method);
            m.setAccessible(true);
            Object o = m.invoke(object);
            return (T) o;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
