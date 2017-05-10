package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

        String str = "C:\\Users\\PC1\\YandexDisk\\Рабочая папка\\Java\\JavaRushTasks\\out" +
                "\\production\\4.JavaCollections\\com\\javarush\\task\\task35\\task3507\\data";
        System.out.println(str);

        Set<? extends Animal> allAnimals = getAllAnimals(str);
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws FileNotFoundException {
        Set<Animal> result = new HashSet<>();
        boolean isAnimal = false;
        boolean isPublicConstructor = false;


        //Добавляем если требуется сепаратор в конец пути pathToAnimals
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + File.separator;


        //Получаем список классов и интерфейсов в заданной директории
        File dir = new File(pathToAnimals);
        String[] classes = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        //Создаем экземпляр нашего класслоадера
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setClassPath(pathToAnimals);

        //Изучаем все найденные файлы
        for (String x:classes) {
            isAnimal = false;
            isPublicConstructor = false;
            try {
                //загружаем найденный класс
                Class<?> clazz = classLoader.loadClass(x.substring(0, x.length()-6));

                //Проверяем содержит ли найденный класс интерфейс Animal
                Class<?>[] ifaces = clazz.getInterfaces();
                for (Class<?> ifs: ifaces) {
                    if(ifs == Animal.class) {
                        isAnimal = true;
                        break;
                    }
                }

                //Получаем список конструкторов не Private
                Constructor[] constructors = clazz.getConstructors();

                //Проверяем есть ли у класса публичный конструктор без параметров
                for (Constructor constr: constructors) {
                    if(Modifier.isPublic(constr.getModifiers())&&constr.getParameters().length==0){
                        isPublicConstructor = true;
                        break;
                    }
                }

                //Если найденный клаас емеет публичный конструктор без параметра, и содержит ифейс Animal
                //Добавляем новый экземпляр этого класса в сет
                if(isAnimal&&isPublicConstructor){
                    result.add((Animal) clazz.newInstance());
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    //Создаем свой загрузчик, для того чтобы загружать классы из нужной дирректории
    public static class MyClassLoader extends ClassLoader{
        private String classPath = "";
        public void setClassPath(String classPath) {
            this.classPath = classPath;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] b = Files.readAllBytes(Paths.get(classPath + name + ".class"));
                return defineClass(null, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
                return super.findClass(name);
            }
        }
    }
}
