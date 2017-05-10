package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
//        String fileName = "h:\\1.txt";
        rd.close();
        if ("-c".equals(args[0])){
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String id = "";
            while (reader.ready()){
                id = reader.readLine();
                list.add(id);

            }
            reader.close();
            id = id.substring(0,id.indexOf(" ")>=0 && id.indexOf(" ")<=7 ?id.indexOf(" "):8);
            int idInc = Integer.parseInt(id)+1;
            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            if (productName.length()>30)
                productName = productName.substring(0,30);
            if (price.length()>8)
                price = price.substring(0,8);
            if (quantity.length()>4)
                quantity = quantity.substring(0,4);
            while (productName.length()<30){
                productName+=" ";
            }
            while (price.length()<8){
                price+=" ";
            }
            while (quantity.length()<4){
                quantity+=" ";
            }
            String outputString = String.valueOf(idInc)+productName+price+quantity;
            FileOutputStream outputStream = new FileOutputStream(fileName);
            for (int i = 0; i < list.size();i++)
            {
                if (list.get(i).equals("")) continue;
                outputStream.write(String.format("%s%n", list.get(i)).getBytes());
            }
            outputStream.write(outputString.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}

