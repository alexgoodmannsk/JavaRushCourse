package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by PC1 on 26.03.2017.
 */
public class CustomInvocationHandler implements InvocationHandler {

    private SomeInterfaceWithMethods sifw;

    public CustomInvocationHandler(SomeInterfaceWithMethods sif) {
        this.sifw =sif;
    }

    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + " " + "in");
        method.invoke(sifw,args);
        System.out.println(method.getName() + " " + "out");

        return method.invoke(sifw,args);
    }
}
