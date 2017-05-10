package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        int result = -1;
        list.add(reader.readLine());
        for (int i = 1; i < 10; i++) {
            String str = reader.readLine();
            if(str.length()<list.get(i-1).length()){
                result = i;
            }
            list.add(str);
        }
        if(result!=-1) System.out.println(result);
     }
}

