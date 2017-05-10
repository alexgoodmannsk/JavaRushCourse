package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("user"+i, i*100);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            Integer value = map.get(key);
            if(value<500){
                map.remove(key);
                iterator = map.keySet().iterator();
            }
        }
    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());

    }
}