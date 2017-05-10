package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream streamIn = new FileInputStream(file1);
        FileOutputStream streamOut1 = new FileOutputStream(file2);
        FileOutputStream streamOut2 = new FileOutputStream(file3);
        int size = streamIn.available();
        int sizeBuf2 = size / 2;
        int sizeBuf1 = size - sizeBuf2;;
        byte[] buff1 = new byte[sizeBuf1];
        byte[] buff2 = new byte[sizeBuf2];
        streamIn.read(buff1);
        streamOut1.write(buff1);
        streamIn.read(buff2);
        streamOut2.write(buff2);
        reader.close();
        streamIn.close();
        streamOut1.close();
        streamOut2.close();
    }
}
