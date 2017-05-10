package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC1 on 06.04.2017.
 */
public class Model {
    public List<String> getStringDataList() {
        return new Service().getData();
    }
}
