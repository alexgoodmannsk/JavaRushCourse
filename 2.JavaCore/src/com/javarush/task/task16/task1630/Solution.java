package com.javarush.task.task16.task1630;




import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Paths.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fullFilename = "";
        private String fileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fullFilename = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        public void run() {
            try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFilename)));
                    String line;
                    while ((line = reader.readLine())!= null){
                        fileContent = fileContent + line + " ";
                    }
                    reader.close();
                    fileContent = fileContent + " ";

            } catch (Exception e) {
                System.out.println("File not find");
            }
        }
    }
    //add your code here - добавьте код тут
}
