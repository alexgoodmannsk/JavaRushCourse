package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();
        FileOutputStream f1stream = new FileOutputStream(f1);
        FileInputStream f2stream = new FileInputStream(f2);
        FileInputStream f3stream = new FileInputStream(f3);
        byte[] buff1 = new byte[f2stream.available()];
        byte[] buff2 = new byte[f3stream.available()];
        f2stream.read(buff1);
        f1stream.write(buff1);
        f3stream.read(buff2);
        f1stream.write(buff2);
        reader.close();
        f1stream.close();
        f2stream.close();
        f3stream.close();

    }
}
