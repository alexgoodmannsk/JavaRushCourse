package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        if(!packageName.endsWith(File.separator)) packageName+=File.separator;
        File dir = new File(packageName);
        String[] classes = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    byte[] buff = Files.readAllBytes(Paths.get(packageName+name+ ".class"));
                    return defineClass(null, buff, 0, buff.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    return super.findClass(name);
                }
            }
        };
        for (String x: classes){
            hiddenClasses.add(loader.loadClass(x.substring(0,x.length()-6)));
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        //ищем класс по ключу
        Class clazz = null;
        for (Class x : hiddenClasses) {
            if (x.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                clazz = x;
                break;
            }
        }
        //если класс  не найден то возвращаем null
        if(clazz==null) return null;

        //есди класс найден ищем конструктор без параметров, и делаем его доступным для вызова
        //далее возвращаем экземпляр класса созданный через конструктор
        try {
            Constructor[] cons = clazz.getDeclaredConstructors();
            for (Constructor x : cons) {
                if (x.getParameterTypes().length == 0) {
                    x.setAccessible(true);
                    return (HiddenClass) x.newInstance();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

