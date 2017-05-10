package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
    return this.foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean icontainsName = true;
        boolean icontainsContent = true;

        //Проверяем усвовие вхождения в название файла
        if(partOfName!=null&&!file.getFileName().toString().contains(partOfName))
            icontainsName = false;
        //Поверяем условие вхождения в тело файла
        String content = new String(Files.readAllBytes(file));
        if (partOfContent!=null&&!content.contains(partOfContent))
            icontainsContent = false;

        //Проверяем выполнение всех условий одновременно
        if(icontainsName&&icontainsContent&&(minSize == 0 || Files.size(file) > (long)minSize) && (maxSize == 0 || Files.size(file) < (long)maxSize))
            this.foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }
}
