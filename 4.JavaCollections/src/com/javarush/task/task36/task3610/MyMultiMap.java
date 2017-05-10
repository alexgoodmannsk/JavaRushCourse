package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (HashMap.Entry x: map.entrySet()) {
            List a = (List) x.getValue();
            size+= a.size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        if(!map.containsKey(key)){
            List<V> list = new ArrayList<V>();
            list.add(value);
            map.put(key, list);
            return null;
        }
        else if(map.get(key).size()<repeatCount){
            List<V> list = map.get(key);
            list.add(value);
            return list.get(list.size()-2);
        }
        else {
            List<V> list = map.get(key);
            list.remove(0);
            list.add(value);
            return list.get(list.size()-2);
        }
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key)) {
            return null;
        }
        V result = map.get(key).get(0);
        map.get(key).remove(0);
        if(map.get(key).isEmpty()) map.remove(key);
        return result;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<V>();
        for (K x:  map.keySet()) {
            list.addAll(map.get(x));
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (K x:  map.keySet()) {
            if(map.get(x).contains(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}