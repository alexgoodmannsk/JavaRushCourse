package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        PrintStream system = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream pod = new PrintStream(stream);
        System.setOut(pod);
        testString.printSomething();
        FileOutputStream fileOutputStream = new FileOutputStream(name);
        fileOutputStream.write(stream.toByteArray());
        System.setOut(system);
        String str = stream.toString();
        System.out.println(str);
        stream.close();
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

