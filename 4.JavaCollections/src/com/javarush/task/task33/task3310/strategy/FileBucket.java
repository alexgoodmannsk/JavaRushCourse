package com.javarush.task.task33.task3310.strategy;


import com.javarush.task.task33.task3310.Helper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by PC1 on 20.04.2017.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(Helper.generateRandomString(), null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        }
        catch (IOException e) {

        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {

        }
        return 0L;
    }

    public void putEntry(Entry entry) {
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));)
        {
            oos.writeObject(entry);
        }
        catch (Exception e) {

        }
    }

    public Entry getEntry() {
        if(getFileSize()>0) {
            Entry entry = null;
            try (ObjectInputStream oos = new ObjectInputStream(Files.newInputStream(path));) {
                entry = (Entry) oos.readObject();
                return entry;
            } catch (Exception e) {

            }
        }
        return null;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {

        }
    }
}
