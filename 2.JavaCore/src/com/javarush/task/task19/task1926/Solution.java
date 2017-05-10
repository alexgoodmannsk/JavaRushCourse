package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        BufferedReader br = new BufferedReader(new FileReader(name));
        String s;
        while ((s=br.readLine())!=null) {
            StringBuilder sOut = new StringBuilder(s);
            System.out.println(sOut.reverse());
        }
        reader.close();
        br.close();
    }
}
