package com.javarush.task.task36.task3602;


import java.lang.reflect.Modifier;
import java.util.*;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        List<Class> list = new ArrayList();
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz: classes) {
            if(Modifier.isStatic(clazz.getModifiers())&&Modifier.isPrivate(clazz.getModifiers())) {
                if (clazz.getSuperclass() == AbstractList.class) list.add(clazz);
                else {
                    Class[] ifaces = clazz.getInterfaces();
                    for (Class ifase : ifaces) {
                        if (ifase == List.class) {
                            list.add(clazz);
                        }
                    }
                }
            }
        }

        return list.get(2);
    }
}
