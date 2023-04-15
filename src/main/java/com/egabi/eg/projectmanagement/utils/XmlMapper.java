package com.egabi.eg.projectmanagement.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class XmlMapper <T>{

    public String mapPojoToXmlToString( T t) throws JAXBException {
        ByteArrayOutputStream xmlOut = new ByteArrayOutputStream();

        mapPojoToXml(xmlOut,t);

        String res = "";

        res = new String (xmlOut.toByteArray(), StandardCharsets.UTF_8);

//        System.out.println("Res>>>"+res);

        return res;
    }

    public boolean mapPojoToXmlAndWriteToFile( T t,String fileName) throws JAXBException {
        OutputStream out =null;
        boolean res =false;

        if(t==null || fileName==null){
            return res;
        }

        try {
            out = new FileOutputStream(fileName);
            mapPojoToXml(out,t);
            out.flush();
            res =true;
        }catch(Exception e){
            e.printStackTrace();
        }

        return res;
    }

    private void mapPojoToXml(OutputStream xmlOut, T t) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        jaxbMarshaller.marshal(t,xmlOut);

    }



}
