package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        String str = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        reader.close();
        String[] param = str.split("[?&]");
        List<String> paramMap = new ArrayList<String>();
        for (int i = 1; i < param.length; i++) {
            String paramin[] = param[i].split("=");
            if(paramin.length > 1 ) {paramMap.add(paramin[0]); paramMap.add(paramin[1]);}
            else {paramMap.add(paramin[0]); paramMap.add(null);}
        }
        for (int i = 0; i < paramMap.size() ; i=i+2) {
            System.out.print(paramMap.get(i)+" ");
        }
        System.out.print("\n");
        if(paramMap.contains("obj")&&paramMap.indexOf("obj")+1<paramMap.size()&&!paramMap.get(paramMap.indexOf("obj")+1).isEmpty()){
            String obj = paramMap.get(paramMap.indexOf("obj")+1);
            try {
                alert(Double.parseDouble(obj));
            }catch (Exception e){
                alert(obj);
            }
        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
