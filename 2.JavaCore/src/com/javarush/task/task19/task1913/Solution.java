package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
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
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(str);
        String fin = "";
        while (m.find()){
            fin+=m.group(1);
        }
        System.out.println(fin);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
