package com.javarush.task.task17.task1721;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = null;
        String fileName2 = null;
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1), StandardCharsets.UTF_8));
            BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2), StandardCharsets.UTF_8));
            allLines = Files.readAllLines(Paths.get(fileName1), StandardCharsets.UTF_8);
            forRemoveLines = Files.readAllLines(Paths.get(fileName2), StandardCharsets.UTF_8);
            fileReader1.close();
            fileReader2.close();
            reader.close();
        }catch (IOException e){
            System.out.println("Файл не найден");
            return;
        }

        try {
            Solution a = new Solution();
            a.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else{
            allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }

    }
}
