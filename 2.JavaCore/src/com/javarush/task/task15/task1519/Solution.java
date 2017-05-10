package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        while (true){
            String str = reader.readLine();
            if (str.equals("exit")) break;
            list.add(str);
        }
        reader.close();
        for(int i=0; i<list.size(); i++){
            try {
                if (list.get(i).contains("."))
                {
                    print(Double.parseDouble(list.get(i)));
                    continue;
                }
                int a= Integer.parseInt(list.get(i));
                if(a > 0 && a < 128) print((short) a);
                else print(a);
            }catch (NumberFormatException e){
                print(list.get(i));
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
