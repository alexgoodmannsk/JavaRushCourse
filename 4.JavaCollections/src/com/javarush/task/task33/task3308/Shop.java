package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by PC1 on 30.03.2017.
 */
//@XmlType(name = "shop")
@XmlRootElement
public class Shop {
//    @XmlElement
    public Goods goods;
//    @XmlElement(name = "count")
    public int count;
//    @XmlElement(name = "profit")
    public double profit;

    public String[] secretData;

    public static class Goods{

        public  List<String> names;
    }
}
