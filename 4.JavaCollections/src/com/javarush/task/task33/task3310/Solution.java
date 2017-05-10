package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.*;

/**
 * Created by PC1 on 14.04.2017.
 */
public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy = new FileStorageStrategy();
        testStrategy(strategy, 10);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String x: strings) {
            set.add(shortener.getId(x));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long x: keys) {
            set.add(shortener.getString(x));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Set<String> strings = new HashSet<>();
        Set<Long> iDs;
        Set<String> strs;
        Helper.printMessage(strategy.getClass().getSimpleName());
        for (long i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        iDs = getIds(shortener, strings);
        Date finish = new Date();
        Helper.printMessage(String.valueOf(finish.getTime()-start.getTime()));

        start = new Date();
        strs = getStrings(shortener, iDs);
        finish = new Date();
        Helper.printMessage(String.valueOf(finish.getTime()-start.getTime()));

        if (strings.equals(strs)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
