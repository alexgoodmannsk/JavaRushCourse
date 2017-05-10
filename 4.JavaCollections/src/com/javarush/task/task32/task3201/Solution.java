package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args)  {
        long pos = Long.parseLong(args[1]);
        String text = args[2];
        try(RandomAccessFile file = new RandomAccessFile(args[0], "rw");){
            if(file.length()<pos){
//                    file.setLength(file.length()+text.getBytes().length);
                    file.seek(file.length());
                    file.write(text.getBytes());
            }else {
                file.seek(pos);
                file.write(text.getBytes());
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
