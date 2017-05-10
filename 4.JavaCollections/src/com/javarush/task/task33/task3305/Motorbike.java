package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("motorbike")
public class Motorbike extends Auto {
    private String owner;

    public Motorbike(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "motorbike{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}