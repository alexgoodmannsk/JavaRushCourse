package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("h:\\1.txt");
            InputStream inputStream = new FileInputStream("h:\\1.txt");

            JavaRush javaRush = new JavaRush();

            User user = new User();
            user.setFirstName("Masha");
            user.setLastName("Ivanova");
            user.setBirthDate(new Date());
            user.setMale(false);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

/*
            JavaRush javaRush1 = new JavaRush();

            User user1 = new User();
            user1.setFirstName("Ryan");
            user1.setLastName("Smit");
            user1.setBirthDate(new Date());
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            javaRush1.users.add(user1);

            javaRush1.save(outputStream);
            outputStream.flush();
*/

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);


            System.out.println(javaRush.equals(loadedObject));


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println("start");
            if (!this.users.isEmpty()){
                writer.println(users.size());
                for (int i=0; i<users.size(); i++){
                    writer.println(this.users.get(i).getFirstName());
                    writer.println(this.users.get(i).getLastName());
                    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    writer.println(format.format(this.users.get(i).getBirthDate()));
                    writer.println(this.users.get(i).isMale());
                    writer.println(this.users.get(i).getCountry());
                }
            }else writer.println(0);
            writer.println("end");
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().equals("start")){
                int count = Integer.parseInt(reader.readLine());
                for (int i = 0; i < count; i++) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    user.setBirthDate(format.parse(reader.readLine()));
                    user.setMale(reader.readLine().equals("true") ? true : false);
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    this.users.add(user);
                }
            }
            if(!reader.readLine().equals("end")) System.out.println("ошибка");
            reader.close();
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
