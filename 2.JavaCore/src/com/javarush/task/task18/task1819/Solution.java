package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/



import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();


        FileInputStream f1InStream = new FileInputStream(f1);
        byte[] buf = new byte[f1InStream.available()];
        f1InStream.read(buf);
        f1InStream.close();
        FileInputStream f2InStream = new FileInputStream(f2);
        FileOutputStream f2OutStream = new FileOutputStream(f1);
        byte[] buf2 = new byte[f2InStream.available()];
        f2InStream.read(buf2);
        byte[] res = new byte[buf.length+buf2.length];
        System.arraycopy(buf2, 0, res, 0, buf2.length);
        System.arraycopy(buf, 0, res, buf2.length, buf.length);
        f2OutStream.write(res);

        f2InStream.close();
        f2OutStream.close();
        reader.close();


    }
}
