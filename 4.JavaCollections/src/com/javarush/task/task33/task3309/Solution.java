package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;


/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
/*
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance();
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, sw);
        String xmlObj = sw.toString();
*/
        return null;

    }

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, IOException, SAXException {

        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<first>\n" +
                "<second>some string</second>\n" +
                "<second>some string</second>\n" +
                "<second><![CDATA[need CDATA because of <second>]]></second>\n" +
                "<second/>\n" +
                "</first>";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new InputSource(new StringReader(str)));
        System.out.println(document);

    }
}






