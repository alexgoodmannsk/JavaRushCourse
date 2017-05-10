package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root = new Entry<>(null);

    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 0; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list.size());

        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
//        list.remove("3");
//        list.size();
        for (int i = 0; i < 16; i++) {
            System.out.println(((CustomTree) list).getParent(String.valueOf(i)));
        }

        list.size();

//        System.out.println("etn");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        boolean isIns=false;
        queue.add(root);
        while (!queue.isEmpty()&&!isIns){
            Entry<String> currentEntry = queue.remove();
            if(currentEntry.leftChild!=null&&currentEntry.rightChild!=null){
                queue.add(currentEntry.leftChild);
                queue.add(currentEntry.rightChild);
            }
            else if(currentEntry.leftChild==null&&currentEntry.rightChild!=null) queue.add(currentEntry.rightChild);
            else if(currentEntry.leftChild!=null&&currentEntry.rightChild==null){
                Entry<String> newEntry = new Entry<>(s);
                newEntry.parent=currentEntry;
                currentEntry.rightChild = newEntry;
                currentEntry.checkChildren();
                isIns=true;
            }
            else {
                Entry<String> newEntry = new Entry<>(s);
                newEntry.parent=currentEntry;
                currentEntry.leftChild = newEntry;
                currentEntry.checkChildren();
                isIns=true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        String s = (String) o;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        boolean isRemove=false;
        queue.add(root);
        while (!queue.isEmpty()&&!isRemove){
            Entry<String> currentEntry = queue.remove();
            if(!currentEntry.equals(root)&&currentEntry.elementName.equals(s)){
                if(currentEntry.parent!=null) {
                    if (currentEntry.parent.rightChild != null && currentEntry.parent.rightChild.elementName.equals(currentEntry.elementName)) {
                        currentEntry.parent.rightChild = null;
                    } else currentEntry.parent.leftChild = null;
                    isRemove = true;
                }else {
                    root = null;
                }
            }
            else {
                if(currentEntry.leftChild==null&&currentEntry.rightChild==null) continue;
                else if(currentEntry.leftChild==null&&currentEntry.rightChild!=null) queue.add(currentEntry.rightChild);
                else if(currentEntry.leftChild!=null&&currentEntry.rightChild==null) queue.add(currentEntry.leftChild);
                else {
                    queue.add(currentEntry.leftChild);
                    queue.add(currentEntry.rightChild);
                }
            }
        }


        return true;
    }


    @Override
    public int size() {
        int count=0;
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Entry<String> currentEntry = queue.remove();
            if (currentEntry.leftChild != null) {
                queue.add(currentEntry.leftChild);
                count++;
            }
            if (currentEntry.rightChild != null) {
                queue.add(currentEntry.rightChild);
                count++;
            }
        }
        return count;
    }

    public String getParent(String s){
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<Entry<String>>();
        boolean isFind=false;
        queue.add(root);
        while (!queue.isEmpty()&&!isFind){
            Entry<String> currentEntry = queue.remove();
            if(!currentEntry.equals(root)&&currentEntry.elementName.equals(s)){
                return currentEntry.parent.elementName;

            }
            else {
                if(currentEntry.leftChild==null&&currentEntry.rightChild==null) continue;
                else if(currentEntry.leftChild==null&&currentEntry.rightChild!=null) queue.add(currentEntry.rightChild);
                else if(currentEntry.leftChild!=null&&currentEntry.rightChild==null) queue.add(currentEntry.leftChild);
                else {
                    queue.add(currentEntry.leftChild);
                    queue.add(currentEntry.rightChild);
                }
            }
        }
        return null;
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren(){
            this.availableToAddLeftChildren = leftChild==null?true:false;
            this.availableToAddRightChildren = rightChild==null?true:false;
        }

        @Override
        public String toString() {
            String name = this==null?"null":this.elementName;
            String parent = this.parent==null?"null":this.parent.elementName;
            String left = this.leftChild==null?"null":this.leftChild.elementName;
            String right = this.rightChild==null?"null":this.rightChild.elementName;

            return "name: " + name + " parent= " + parent + " left = " + left + " right = " + right;
        }

        boolean isAvailableToAddChildren(){
            return this.availableToAddLeftChildren||this.availableToAddRightChildren;
        }
    }
}
