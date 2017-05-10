package com.javarush.task.task31.task3113;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by PC1 on 22.03.2017.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path>{
    public long size=0;
    public int count = 0;
    public int countDir = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        count++;
        size+= Files.size(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countDir++;
        return FileVisitResult.CONTINUE;
    }
}
