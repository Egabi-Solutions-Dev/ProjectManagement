package com.egabi.eg.projectmanagement.utils;

//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.stream.JsonReader;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.bouncycastle.asn1.ASN1ObjectIdentifier;
//import org.bouncycastle.asn1.DERTaggedObject;
//import org.bouncycastle.asn1.DLSequence;
//import org.bouncycastle.asn1.DLTaggedObject;
//import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
//import org.bouncycastle.asn1.x500.RDN;
//import org.bouncycastle.asn1.x500.X500Name;
//import org.bouncycastle.asn1.x500.X500NameStyle;
//import org.bouncycastle.asn1.x500.style.RFC4519Style;
//import org.bouncycastle.asn1.x509.GeneralName;
//import org.bouncycastle.asn1.x509.GeneralNames;
//import org.bouncycastle.cert.X509CertificateHolder;
//import org.bouncycastle.cms.CMSSignedData;
//import org.bouncycastle.cms.SignerInformation;
//import org.bouncycastle.cms.SignerInformationStore;
//import org.bouncycastle.util.Store;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {
    private static String RESOURCE_BUNDLE_NAME = "ValidationMessages";
    private static String integrationConfigFileName;
    
    public static String getPropertyValueFromBundle(String key) {
        String value = null;
        try {
            final ResourceBundle messagesBundle = ResourceBundle.getBundle(integrationConfigFileName, Locale.getDefault());
            value = messagesBundle.getString(key);
        } catch (Exception e) {
            System.out.println("Eroro while load attributes");
//            e.printStackTrace();
        }
        return value;
    }
    public static String convertInputStreamToString(InputStream inputStream) {

        //creating an InputStreamReader object
        InputStreamReader isReader = new InputStreamReader(inputStream);
        //Creating a BufferedReader object
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            System.err.println(">> SKH >> Utils.convertInputStreamToString >> " );
            e.printStackTrace();
            return null;
        }
    }

    public static String convertXmlDocToString(Document doc) throws TransformerConfigurationException,
                                                                    TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();

        transformer.transform(source, new StreamResult(writer));
        return writer.getBuffer().toString();
    }
    
    public static Date convertStringToUtilDate(String date,String format){
        if(date==null || format==null){
            return null;
        }
        
        Date dt=null;
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            dt = sdf.parse(date);
            System.out.println(dt.toInstant());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
        
    }
    public static java.sql.Date convertUtilDateToSQLDate(Date date){
        if(date==null){
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dt=null;
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            String d =sdf.format(date);
        
            dt = java.sql.Date.valueOf(d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return dt;
        
        }
    public static <E> E mapXmlToPojo(InputStream xml, E e) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(e.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        E response = (E) jaxbUnmarshaller.unmarshal(xml);
        return response;
    }

    public static <E> E mapXmlToPojo(String xml, E e) throws JAXBException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        return mapXmlToPojo(is, e);
    }

    public static Document convertInputStreamToXMLDocument(InputStream in) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         
        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();
             
            //Parse the content to Document object
            Document doc = builder.parse(in);
            return doc;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Document convertInputStreamToXMLDocument(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try
        {
            builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xml));
            Document doc = builder.parse(is);
            return doc;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    
    
    public static String getXmlElementValue( Element element,String tagName) {
            NodeList list = element.getElementsByTagName(tagName);
            if (list != null && list.getLength() > 0) {
                NodeList subList = list.item(0).getChildNodes();

                if (subList != null && subList.getLength() > 0) {
                    return subList.item(0).getNodeValue();
                }
            }

            return null;
        }
    public static void readCet() {
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\Hussien Hamdy\\Downloads\\application.bin.p7b");

            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate cert = cf.generateCertificate(in);
            System.out.println(cert);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            //extractDataFromBase64Cert(null);
            setIntegrationConfigFileName("com.egabi.mosdintegration.clients.common.WSStagingConfig");
            
            String errorMessage = "";
            try {
                // get access to the error messages bundle
                final ResourceBundle messagesBundle = ResourceBundle.getBundle(integrationConfigFileName, Locale.getDefault());
                // construct the error message
                errorMessage = messagesBundle.getString("WS.ROP.PERSONAL_INFORMATION.SSL.MAX_TOTAL_CONNECTIONS");
                System.out.println(errorMessage);
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {
        }
        //writeToFile("C:\\Users\\Hussien.Hamdy\\Downloads.xml","heloooooooooo");
        
    }

 
 
 
 
     public static boolean createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
     
    public static boolean writeToFile(String fileName, String fileContent) {
        try {
            if (createFile(fileName)) {
                FileWriter fileWriter = new FileWriter(fileName);
                fileWriter.write(fileContent);
                fileWriter.close();
                System.out.println("Successfully wrote to the file.");
                return true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean writeToFile(String path, String fileName, String fileContent){
       try {
           File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }

            File file2 = new File(path + fileName);
            FileWriter fw = new FileWriter(file2.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent);
            bw.close();

        } catch (IOException e) {
           e.printStackTrace();
       }
       return false;
    }


    public static void setIntegrationConfigFileName(String integrationConfigFileName) {
        Utils.integrationConfigFileName = integrationConfigFileName;
    }

    public static String getIntegrationConfigFileName() {
        return integrationConfigFileName;
    }
//
//    public static String mapObjectToJSON(Object obj){
//        String jsonText=null;
//        if (obj!=null){
//            Gson builder=new GsonBuilder().disableHtmlEscaping().create();
//            jsonText=builder.toJson(obj);
//        }
//        return jsonText;
//    }
//
//    public static String mapObjectToJSONPretty(Object obj){
//        String jsonText=null;
//        if (obj!=null){
//            Gson builder=new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
//            jsonText=builder.toJson(obj);
//        }
//        return jsonText;
//    }
//
//    public static Object mapJSONToObject(String jsonString,Class<?> objType){
//        Object obj=null;
//        if (jsonString!=null){
//            obj=new Gson().fromJson(jsonString,objType );
//        }
//        return obj;
//    }

    public static String convertDateUtilToStringFormat(Date date , String format) {
        SimpleDateFormat form = new SimpleDateFormat(format);
        if (date != null) {
            return form.format(date);
        }
        return null;
    }

    public static String convertMapToString(Map<String, ?> map) {
        if (map !=null) {
            StringBuilder mapAsString = new StringBuilder("{");
            for (String key : map.keySet()) {
                mapAsString.append(key + "=" + map.get(key) + ", ");
            }
            mapAsString.delete(mapAsString.length() - 2, mapAsString.length()).append("}");
            return mapAsString.toString();
        }
        return null;
    }
    public static String returnFirstNodeValueFromXML(String xml, String nodeName) {
        if (xml!=null && !xml.isEmpty() &&
                nodeName!=null && !nodeName.isEmpty()){
            try {
                Document doc = Utils.convertInputStreamToXMLDocument(xml);
                Node first = doc.getElementsByTagName(nodeName).item(0);
                return first.getTextContent();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String returnFirstNodeItemValueFromXML(String xml,String nodeName,String itemName){
        if (xml!=null && !xml.isEmpty() &&
                nodeName!=null && !nodeName.isEmpty() &&
                itemName!=null && !itemName.isEmpty()){
            try {
                Document doc = Utils.convertInputStreamToXMLDocument(xml);
                Node node = doc.getElementsByTagName(nodeName).item(0);
                return node.getAttributes().getNamedItem(itemName).getNodeValue();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Integer getResourceMessageAsInteger(String key){

        Integer val = 0;
        try {
            Locale locale = new Locale("en", "US");
            ResourceBundle exampleBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME);
            if (exampleBundle == null || key == null || key.isEmpty()) {
                return val;
            }

            val = new Integer(exampleBundle.getString(key));

            System.out.println(key + ">>>>>>>>>" + exampleBundle.getString(key));
        }catch(Exception e){
            e.printStackTrace();
            val=0;
        }
        return val;
    }

}
