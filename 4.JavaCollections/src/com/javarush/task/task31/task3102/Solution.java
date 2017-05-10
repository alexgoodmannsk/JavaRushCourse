package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fin = new ArrayList<>();
        Stack<File> files = new Stack<>();
        File fileRoot = new File(root);
        files.push(fileRoot);
        while (!files.isEmpty()){
            File child = files.pop();
            if (!child.isFile()){
                File[] fl = child.listFiles();
                for (File x: fl) {
                    files.push(x);
                }
            }
            else fin.add(child.getAbsolutePath());
        }

        return fin;
    }

    public static void main(String[] args) {
        
    }
}
