package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/


import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname1 = reader.readLine();
        String fname2 = reader.readLine();
        FileInputStream file1 = new FileInputStream(fname1);
        FileOutputStream file2 = new FileOutputStream(fname2);
        int size = file1.available();
        byte[] buff = new byte[size];
        file1.read(buff);
        byte tmp;
        for (int i = 0; i<size/2; i++) {
            tmp = buff[i];
            buff[i] = buff[size - i - 1];
            buff[size-i-1] = tmp;
        }
        file2.write(buff);
        reader.close();
        file1.close();
        file2.close();
    }
}
