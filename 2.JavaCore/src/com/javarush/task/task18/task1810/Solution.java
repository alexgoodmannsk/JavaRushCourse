package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
//        List<FileInputStream> list = new ArrayList<FileInputStream>();

        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            reader.close();
            FileInputStream stream = new FileInputStream(name);
//            list.add(stream);
//            File file = new File(name);
//            long size = file.length();

            if (stream.available()<1000){
//                for (FileInputStream x: list) {
//                    x.close();
//                }
                stream.close();
                throw new DownloadException();
            }
            stream.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
