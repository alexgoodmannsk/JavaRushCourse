package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String name="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileInputStream file = new FileInputStream(name);
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                System.out.println(name);
                return;
            }
        }
    }

}
