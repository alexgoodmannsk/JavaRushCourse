package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by PC1 on 06.04.2017.
 */
public class View {
    public void fireEventShowData() {
        System.out.println(new Controller().onDataListShow());
    }

}
