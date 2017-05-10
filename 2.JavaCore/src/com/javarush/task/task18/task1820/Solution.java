package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        FileInputStream reader1 = new FileInputStream(f1);
        FileOutputStream stream = new FileOutputStream(f2);
        byte[] buff = new byte[reader1.available()];
        reader1.read(buff);
        String input = new String(buff);
        String[] str = input.split(" ");
        String res = "";
        for (int i = 0; i < str.length; i++) {
            res+= Math.round(Double.parseDouble(str[i]))+" ";
        }
        byte[] buffOut = res.getBytes();
        stream.write(buffOut);
        reader1.close();
        stream.close();

    }
}
