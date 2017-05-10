package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        InputStream in = new FileInputStream(name);
        load(in);
        in.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        props.putAll(properties);
        props.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        props.load(inputStream);
        Set<String> list = props.stringPropertyNames();
        for (String x: list) {
            properties.put(x, props.getProperty(x));
        }
    }

    public static void main(String[] args) throws Exception {
        OutputStream out = new FileOutputStream("h:\\2.txt");
        Solution sol = new Solution();
        sol.fillInPropertiesMap();
        sol.save(out);
    }
}
