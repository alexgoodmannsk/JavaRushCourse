package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
    private ATableInterface iface;
    public TableInterfaceWrapper(ATableInterface a){
        iface = a;
    }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            iface.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return iface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            iface.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}