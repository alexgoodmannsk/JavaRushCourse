package com.javarush.task.task31.task3107;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path ptf = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(ptf), Files.isExecutable(ptf), Files.isDirectory(ptf), Files.isWritable(ptf));
        }catch (Exception e){
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
