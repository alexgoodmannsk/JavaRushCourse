package com.javarush.task.task33.task3308;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

/* 
Создание класса по строке xml
*/
public class Solution {
    public static void main(String[] args) throws JAXBException {
        Shop shop = new Shop();
        shop.goods = new Shop.Goods();
        shop.goods.names = new ArrayList<>();
        shop.goods.names.add("S1");
        shop.goods.names.add("S2");
        shop.count = 12;
        shop.profit = 123.4;
        shop.secretData = new String[]{"String1","String2","String3","String4","String5"};
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(shop,sw);
        System.out.println(sw.toString());

/*                String xmlData =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<shop>\n" +
                        "    <goods>\n" +
                        "        <names>S1</names>\n" +
                        "        <names>S2</names>\n" +
                        "    </goods>\n" +
                        "    <count>12</count>\n" +
                        "    <profit>123.4</profit>\n" +
                        "    <secretData>String1</secretData>\n" +
                        "    <secretData>String2</secretData>\n" +
                        "    <secretData>String3</secretData>\n" +
                        "    <secretData>String4</secretData>\n" +
                        "    <secretData>String5</secretData>\n" +
                        "</shop>";

        StringReader reader = new StringReader(xmlData);

        JAXBContext context = JAXBContext.newInstance(getClassName());
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Object o = unmarshaller.unmarshal(reader);

        System.out.println(o.toString());
    }

    public static Class getClassName() {
        return Shop.class;  //your class name
    }

*/
    }
}