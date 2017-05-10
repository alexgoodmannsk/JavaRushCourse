package com.javarush.task.task34.task3408;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if(cache.get(key)!=null) return cache.get(key);
        else {
            Constructor constructor = clazz.getConstructor(key.getClass());
            cache.put(key,(V)constructor.newInstance(key));
        }
        return null;
    }

    public boolean put(V obj)  {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj, null);
            cache.put(key, obj);
        } catch (NoSuchMethodException e) {
            return false;
        } catch (IllegalAccessException e) {
            return false;
        } catch (InvocationTargetException e) {
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}
