package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static List<File> files = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        String path = args[0];
        File resultFileAbsolutePath = new File(args[1]); //Файл с контекстом всех файлом <50
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        FileOutputStream fos = new FileOutputStream(allFilesContent);
        fos.close();
        list(new File(path));
        for(int i=0; i< files.size(); i++) {
            try (FileInputStream in = new FileInputStream(files.get(i));) {
                if (in.available() > 50) {
                    in.close();
                    FileUtils.deleteFile(files.get(i));
                    files.remove(i);
                    i--;
                }
            }
        }

        Collections.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareTo(name2);
            }
        });



        try(FileOutputStream stream = new FileOutputStream(allFilesContent);) {
            for (File x:files) {
                try (FileInputStream inputStream = new FileInputStream(x);) {
                    while (inputStream.available()>0) {
                        stream.write(inputStream.read());
                    }
                    stream.write(System.lineSeparator().getBytes());
                }
            }
        }


    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void list(File f){
        File[] sDirList = f.listFiles();
        for(int i = 0; i<sDirList.length;i++){
            File f1 = sDirList[i];
            if(f1.isFile()){
                files.add(f1);
            }
            else list(f1);
        }
    }


}
