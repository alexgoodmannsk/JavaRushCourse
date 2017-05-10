package com.javarush.task.task14.task1421;

/**
 * Created by PC1 on 22.02.2017.
 */
public class Singleton {
    private static int count = 0;
    private static Singleton instance = null;
    public static Singleton getInstance()
    {
        if (count == 0){
            instance = new Singleton();
            return instance;}
        else return instance;
    }

    private Singleton()
    {
        count++;
    }
}
