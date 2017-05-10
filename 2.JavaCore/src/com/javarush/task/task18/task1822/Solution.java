package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(name), StandardCharsets.UTF_8));
        String line;
        String[] str;
        String fin = "";
        boolean id = false;
        while (((line = file.readLine())!= null)&&!id){
            fin = "";
            str = line.split(" ");
            for (int i = 0; i < str.length-1; i++) {
                fin+=str[i]+" ";
            }
            fin+=str[str.length-1];
            if(str[0].equals(args[0])) id = true;
        }
        if (!id) throw new IOException("ID не найден");
        file.close();

        System.out.println(fin);
    }
}
