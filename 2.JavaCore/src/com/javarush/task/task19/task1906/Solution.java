package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter((fileName2));
//        int b = fileReader.read();
        while (fileReader.ready()){
            int b = fileReader.read();
//            fileWriter.write(b);
            b = fileReader.read();
            fileWriter.write(b);
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
