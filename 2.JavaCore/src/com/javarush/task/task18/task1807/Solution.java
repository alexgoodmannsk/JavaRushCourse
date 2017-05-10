package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream stream = new FileInputStream(name);
        int count = 0;
        while (stream.available()>0){
            if (stream.read()==44) count++;
        }
        reader.close();
        stream.close();
        System.out.println(count);
    }
}
