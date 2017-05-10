package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream backUp = System.out;
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        PrintStream a = new PrintStream(ba);
        System.setOut(a);
        testString.printSomething();
        String str = ba.toString();
        System.setOut(backUp);
        String[] sl = str.split("\\n");
        for (int i = 0; i < sl.length ; i++) {
            System.out.println(sl[i]);
            if ((i+1)%2==0) System.out.println("JavaRush - курсы Java онлайн");

        }

    }


    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

}
