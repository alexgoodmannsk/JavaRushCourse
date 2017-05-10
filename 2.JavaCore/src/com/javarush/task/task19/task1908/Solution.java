package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        String str = "";
        String pattern = "(^|\\s)([0-9]+)(?=\\s|$)";
        Pattern p = Pattern.compile(pattern);
        String b;
        while ((b=bufferedReader.readLine())!=null){
            str+=b;
        }
        Matcher m = p.matcher(str);
        String fin="";
        while (m.find()){
            fin+=m.group(2)+" ";
        }
        bufferedWriter.write(fin.substring(0,fin.length()-1));
        bufferedReader.close();
        bufferedWriter.close();
    }
}
