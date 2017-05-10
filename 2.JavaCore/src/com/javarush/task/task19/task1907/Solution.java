package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileReader fileReader= new FileReader(name);
        int count = 0;
        String str="";
        while (fileReader.ready()){
            char symbol = (char) fileReader.read();
            str += String.valueOf(symbol);
        }
        String pattern = "(^|\\W)(world)(\\W|$)";
        Pattern p = Pattern.compile(pattern);

            Matcher m = p.matcher(str);
            while (m.find()) {
               count++;
            }

        System.out.println(count);
        fileReader.close();
    }
}
