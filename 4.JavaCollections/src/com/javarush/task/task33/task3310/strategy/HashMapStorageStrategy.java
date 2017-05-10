package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

/**
 * Created by PC1 on 14.04.2017.
 */
public class HashMapStorageStrategy implements StorageStrategy {

    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        if(data.containsValue(value)){
            for (Long x: data.keySet()) {
                if(data.get(x).equals(value)) return x;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
