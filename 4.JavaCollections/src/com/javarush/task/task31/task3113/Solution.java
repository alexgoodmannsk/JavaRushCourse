package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


/* 
Что внутри папки?
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = reader.readLine();
//        String dirName = "h:\\1";

        if(!Files.isDirectory(Paths.get(dirName))) {
            System.out.println(Paths.get(dirName).toAbsolutePath() + " - не папка");
            return;
        }
        else {
            MyFileVisitor fv = new MyFileVisitor();
            Files.walkFileTree(Paths.get(dirName), fv);
            System.out.println("Всего папок - " + (fv.countDir-1));
            System.out.println("Всего файлов - " + fv.count);
            System.out.println("Общий размер - " + fv.size);
        }
    }
}
