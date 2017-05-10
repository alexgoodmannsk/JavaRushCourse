package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream system = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream pod = new PrintStream(stream);
        System.setOut(pod);
        testString.printSomething();
        System.setOut(system);
        String str = stream.toString();
        String[] sp = str.split(" ");
        int result=0;
        if(sp[1].equals("+")) result = Integer.parseInt(sp[0]) + Integer.parseInt(sp[2]);
        if(sp[1].equals("-")) result = Integer.parseInt(sp[0]) - Integer.parseInt(sp[2]);
        if(sp[1].equals("*")) result = Integer.parseInt(sp[0]) * Integer.parseInt(sp[2]);

        String fin = sp[0]+" "+sp[1]+" "+sp[2]+" "+ "="+" "+ result;

        System.out.println(fin);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

