package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outstream);
        System.setOut(stream);
        testString.printSomething();
        Pattern p = Pattern.compile("te");
        String result = outstream.toString();
        Matcher m = p.matcher(result);
        String fin = m.replaceAll("??");
        System.setOut(console);
        System.out.println(fin);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
