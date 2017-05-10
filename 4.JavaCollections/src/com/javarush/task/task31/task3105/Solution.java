package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {

    public static Map <ZipEntry, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        File zipArchive = new File(args[1]);
        File addedFile = new File(args[0]);

        zipToMap(zipArchive);
        addNewFileToZIP(addedFile, zipArchive);
    }


    public static void zipToMap(File file)  {

        // Записываем содержимое архива в карту
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file))) {

            ZipEntry zipEntry;

            // перебираем все zipEntries
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int count;

                while ((count = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                entryMap.put(zipEntry, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addNewFileToZIP(File addedFile, File zipArchive) {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipArchive));
             FileInputStream fileInputStream = new FileInputStream(addedFile)) {

            //Маркер наличия добавляемого файла в архиве
            boolean isExist = false;

            //Проверяем наличие файла с тем же именем в архиве что и добавляемый
            for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()){
                if (addedFile.getName().equals(zipEntry.getKey().getName().lastIndexOf("/"))) isExist = true;
            }

            //Если добавляемый файл не содержиться в архиве добавляем его в папку new, и записываем сохраненное содержимое
            //архива обратно в архив
            if (!isExist) {
                zipOutputStream.putNextEntry(new ZipEntry("new"+File.separator+addedFile.getName()));
                Files.copy(addedFile.toPath(), zipOutputStream);
                zipOutputStream.closeEntry();

                for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {
                        //Записываем в архив
                        zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                        zipOutputStream.write(zipEntry.getValue());
                        zipOutputStream.closeEntry();
                }

            }
            //Если архиве нашелся файл с таким-же именем как и добавляемый..
            else{
                for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet()) {
                    //проверяем совпадение имен если есть совпадение ентри берем из мап, содержимое из файла
                    if(addedFile.getName().equals(zipEntry.getKey().getName().lastIndexOf(File.separator))) {
                        //Записываем в архив
                        zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                        Files.copy(addedFile.toPath(), zipOutputStream);
                        zipOutputStream.closeEntry();
                    }
                    //если не совпадает записываем в все из мап
                    else{
                        zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                        zipOutputStream.write(zipEntry.getValue());
                        zipOutputStream.closeEntry();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
