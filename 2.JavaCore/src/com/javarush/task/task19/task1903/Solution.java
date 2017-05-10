package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Contact, Customer {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + "," + " " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String c0 = "";
            while ((Integer.toString(data.getPhoneNumber())+c0).length()<10){
                c0+=0;
            }
            String num = c0 + data.getPhoneNumber();
            String a0 = num.substring(0,3);
            String a1 = num.substring(3,6);
            String a2 = num.substring(6,8);
            String a3 = num.substring(8);

            return "+" + data.getCountryPhoneCode()+"(" +  a0  + ")" + a1 + "-" + a2 + "-" + a3;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}