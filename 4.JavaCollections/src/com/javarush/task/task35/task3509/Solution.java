package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet<>();
        Collections.addAll(hashSet, elements);
        return hashSet;
    }

    public static <K, V> HashMap<K,V> newHashMap(List<? extends K> keys, List< ? extends V> values) {
        if (keys.size()!=values.size()) throw new IllegalArgumentException("123");
        HashMap hashMap = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i), values.get(i));
        }
        return hashMap;
    }
}
