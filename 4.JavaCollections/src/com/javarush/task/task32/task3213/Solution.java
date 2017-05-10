package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, 75));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter = new StringWriter();
        key %= 26;
        if (reader==null) return "ошибка";
        else {
            int r;
            while (reader.ready()&&(r=reader.read())!=-1){
                stringWriter.write(r+key);
            }
        }
        return stringWriter.toString();
    }

}
