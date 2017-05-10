package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by PC1 on 02.04.2017.
 */
public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<E, Object>();
    }

    public AmigoSet(Collection<? extends E> collection){
        map = new HashMap<>((int) Math.max(16, collection.size() / .75f + 1));
        this.addAll(collection);
    }


    @Override
    public boolean add(Object o){
        return null==map.put((E) o, PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return null==map.remove(o);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();

        stream.writeInt(map.size());
        for (E x:map.keySet()) {
            stream.writeObject(x);
        }
        stream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        stream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();

        int sizze = stream.readInt();
        Set<E> set = new HashSet<E>();
        for (int i = 0; i < sizze; i++) {
            set.add((E) stream.readObject());
        }
        int cap = stream.readInt();
        float lf = stream.readFloat();
        map = new HashMap<E, Object>(cap,lf);
        for (E x:set) {
            map.put(x,PRESENT);
        }
    }
}
