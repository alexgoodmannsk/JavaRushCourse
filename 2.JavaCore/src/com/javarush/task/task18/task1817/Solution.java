package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        long countSP = 0;
        long count = 0;
        FileInputStream stream = new FileInputStream(args[0]);
        while (stream.available()>0){
            int ch = stream.read();
            count++;
            if (ch==32) countSP++;
        }
        stream.close();
        double res = 100.0*countSP/count;
        System.out.format("%.2f",res);
    }
}
