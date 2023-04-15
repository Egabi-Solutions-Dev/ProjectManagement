package com.egabi.eg.projectmanagement.utils;


//import com.egabi.eg.zatcaservices.ZatcaSingleton;
//import com.egabi.eg.zatcaservices.intgration.caller.client.dto.CsidResponse;
//import com.egabi.eg.zatcaservices.intgration.caller.client.dto.ZatcaErrors;
//import com.egabi.eg.zatcaservices.invoice.pojo.XMLUtil;
//import com.zatca.sdk.util.ECDSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class ZatcaUtils {
//
//    @Autowired
//    ZatcaSingleton zatcaSingleton;
//
//    public static String convertZatcaErrorToString(ArrayList<ZatcaErrors> errorList){
//        StringBuffer mapAsString = null;
//        if (errorList!=null && errorList.size()>0){
//            mapAsString=new StringBuffer();
//            ZatcaErrors err=null;
//            for (int i=0;i<errorList.size();i++){
//                err=errorList.get(i);
//                mapAsString.append(err.getCode()+ "=" + err.getMessage()+"#&\n");
//            }
//
//        }
//        return mapAsString !=null ? mapAsString.toString() :null;
//    }
//
//    public static String retrivePIH(String pihFilePath){
//        String pih=null;
//        Path path= Paths.get(pihFilePath);
//        try {
//            pih= Files.readAllLines(path).get(0);
//        } catch (IOException e) {
//            e.printStackTrace();
//            pih=null;
//        }
//        return pih;
//    }
//
//    public static PrivateKey readPrivateKeyFromFile(String pkFilePath)  {
//        PrivateKey privateKey=null;
//        try {
//            InputStream pk = new FileInputStream(pkFilePath);
//            String key = new String(pk.readAllBytes(), StandardCharsets.UTF_8);
//            privateKey = ECDSAUtil.getPrivateKey(key);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return privateKey;
//    }
//
//    public static Map<String,PrivateKey> readPKSDataFromFile (String pkFilePath){
//        PrivateKey privateKey=null;
//        Map <String,PrivateKey> returned=null;
//        try {
//            InputStream pk = new FileInputStream(pkFilePath);
//            String key = new String(pk.readAllBytes(), StandardCharsets.UTF_8);
//            privateKey = ECDSAUtil.getPrivateKey(key);
//            returned=new HashMap<>();
//            returned.put(key,privateKey);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return returned;
//    }
//    public static CsidResponse readCSIFromFile (String csiFilePath){
//        CsidResponse response=null;
//        Path path = Paths.get(csiFilePath);
//        try {
//            String csiString= Files.readAllLines(path).get(0);
//            response= (CsidResponse) Utils.mapJSONToObject(csiString,CsidResponse.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }
//    public static String readCsrFromFile (String csrFilePath){
//        String csr=null;
//        Path path = Paths.get(csrFilePath);
//        try {
//            csr = Files.readAllLines(path).get(0);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return csr;
//    }
//
//
//    public String checkZatcaConfigurationFile(){
//        String check=null;
//        if (zatcaSingleton.getProdCSIResponse()==null)
//            check="Production CSI Configuration Not Exist";
//        return check;
//    }
//    public static String appendPihToInvoice(boolean useDefaultHash,String invoicesXMLSTR,String hash) {
//        String xmlStr=null;
//        try {
//            if(useDefaultHash) {
//                hash="NWZlY2ViNjZmZmM4NmYzOGQ5NTI3ODZjNmQ2OTZjNzljMmRiYzIzOWRkNGU5MWI0NjcyOWQ3M2EyN2ZiNTdlOQ==";
//            }
//            Document doc = XMLUtil.convertInputStreamToXMLDocument(invoicesXMLSTR);
//            Node ss = createPIHElement(doc, hash);
//            Node first = doc.getElementsByTagName("cac:AdditionalDocumentReference").item(0);
//            first.getParentNode().insertBefore(ss, first.getNextSibling());
//            xmlStr = XMLUtil.convertXmlDocToString(doc);
//            xmlStr = xmlStr.replaceAll("xmlns=\"\"", "").replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return xmlStr;
//    }
//
//    private static Node createPIHElement (Document doc,String pihValue){
//        Element embeddedDocumentBinaryObject=doc.createElement("cbc:EmbeddedDocumentBinaryObject");
//        embeddedDocumentBinaryObject.setAttribute("mimeCode","text/plain");
//        embeddedDocumentBinaryObject.setTextContent(pihValue);
//        Element attachment=doc.createElement("cac:Attachment");
//        attachment.appendChild(embeddedDocumentBinaryObject);
//        Element id=doc.createElement("cbc:ID");
//        id.setTextContent("PIH");
//        Element additinaLDocRefer=doc.createElement("cac:AdditionalDocumentReference");
//        additinaLDocRefer.appendChild(id);
//        additinaLDocRefer.appendChild(attachment);
//        return additinaLDocRefer;
//    }
//
//
//    public static ArrayList<ZatcaErrors> fillZatcaErrorsFromMap(Map<String,String> errorsMap){
//        if (errorsMap==null)
//            return null;
//        ArrayList <ZatcaErrors>errorsList=new ArrayList<ZatcaErrors>();
//        ZatcaErrors err=null;
//        for (String key : errorsMap.keySet()) {
//            err=new ZatcaErrors(key,errorsMap.get(key) );
//            errorsList.add(err);
//        }
//        return errorsList.size()>0?errorsList :null;
//    }
//
//    public String getZatcaSingletonProperty(String propertyName){
//        if (propertyName!=null && !propertyName.isEmpty()) {
//            return zatcaSingleton.getEnvConfig().getProperty(propertyName);
//        }
//        return null;
//    }
}
