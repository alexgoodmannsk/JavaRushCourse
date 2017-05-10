package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileInputStream stream = new FileInputStream(args[0]);
        int count = 0;
        while (stream.available()>0){
            int b = stream.read();
            if((b >= 97 && b <= 122)||(b>=65 && b<=90)) count++;
        }
        stream.close();
        System.out.println(count);
    }
}
