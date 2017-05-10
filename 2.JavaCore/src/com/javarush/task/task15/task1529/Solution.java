package com.javarush.task.task15.task1529;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String type = reader.readLine();
        switch (type) {
            case "helicopter": {
                result = new Helicopter();
                break;
            }
            case "plane": {
                result = new Plane(Integer.parseInt(reader.readLine()));
                break;
            }
            default: {result = null;}
        }
        reader.close();
    }
}
