package com.javarush.task.task31.task3106;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length<2) return;
        String resultFileName = args[0];
        List<String> zipParts = new ArrayList();
        List<InputStream> zipPartsStreams = new ArrayList<>();

        //Заносим все части зип в лист
        for (int i=1; i<args.length;i++) {
            zipParts.add(args[i]);
        }

        //Сортируем лист зип-частей по возрастанию индекса
        Collections.sort(zipParts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int x1 =  Integer.parseInt(o1.substring(o1.lastIndexOf(".")+1));
                int x2 =  Integer.parseInt(o2.substring(o2.lastIndexOf(".")+1));
                return x1-x2;
            }
        });

        //Запускаем потоки всех зип-частей и складываем в лист потоков
        for (String x:zipParts) {
            zipPartsStreams.add(new FileInputStream(x));
        }
        System.out.println("end0");

        //Записываем из сиквенсора в итоговый файл
        try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(zipPartsStreams)));
             FileOutputStream fos = new FileOutputStream(resultFileName)){
            zis.getNextEntry();
            byte[] buffer = new byte[1024];
            int count;
            while ((count = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, count);
            }
            zis.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end1");
    }
}
