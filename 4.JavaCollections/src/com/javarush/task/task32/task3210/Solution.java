package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        long pos = Long.parseLong(args[1]);
        String text = args[2];
        long lenText = text.getBytes().length;
        try(RandomAccessFile file = new RandomAccessFile(args[0], "rw");){
            file.seek(pos);
            String readText="";
            byte[] buff = new byte[(int) lenText];
            file.read(buff,0,(int)lenText);
            readText = convertByteToString(buff);

            file.seek(file.length());
            if(readText.equals(text)){
                file.write("true".getBytes());
            }else file.write("false".getBytes());

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String convertByteToString(byte[] bt) {
        return new String(bt);
    }
}
