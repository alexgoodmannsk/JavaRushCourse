package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = new FileInputStream(args[1]);
        File file = new File(args[2]);
        FileOutputStream fileOut = new FileOutputStream(args[2],true);
        switch (args[0]){
            case "-e":{
                byte[] buff = new byte[fileIn.available()];
                byte[] sh = {3,3,3,3,3};
                fileIn.read(buff);
                fileOut.write(sh);
                fileOut.write(buff);
                fileOut.close();
                fileIn.close();
                break;
            }
            case "-d":{
                byte[] buff = new byte[fileIn.available()-5];
                byte[] sh = new byte[5];
                fileIn.read(sh);
                fileIn.read(buff);
                fileOut.write(buff);
                fileOut.close();
                fileIn.close();
                break;
            }
        }
    }

}
