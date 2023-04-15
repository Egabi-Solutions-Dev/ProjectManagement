package com.egabi.eg.projectmanagement.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {
    private String encryptionKey = "SixteenByteEnkey";

    private static void printBytes(byte[] s){

        for(int i=0;i<s.length ; i++){

            System.err.print(s[i]+" ");             
            
        }
//        System.err.println();
//        for(int i=0;i<s.length ; i++){
//
//            System.err.print(Integer.toBinaryString(s[i])+" ");             
//            
//        }
        System.err.println();
    }
    
    public static void main(String[] args) throws Exception
        {
//           
//            String plainText = "1شسيمبتشسيباتنشسباشسيباتنشسييابتنشسشسيشسيشسيشس)(*)_&^**&$%#@#!~@#$%^&*()_(+(يشسيشسيايشيشسشسيشسيشسيشسشسيتممهخعشسيمppppssssscيشسييشتسساسيشسيشASDaشسئءؤشسشسيشسيشسيشسييشسيشسيشسيشسيشسيشسيشسيشسيشسيشسيشسيشسيشسيشسيشسيsdششaشسيشسيشسيشسيياsdfasdfasdfaِسيبشسيبas!@#$!#$%^&*&*(&)dfasdfasdfasdfasdfASDسيشسيشسبتاشسيباشتنسيابتنشسايباااsssssسستنستنستنشنشس!@#$!@#%#$%^#^";
            String plainText ="weblogic1";
            
            // encryption Key
            String key =  "SixteenByteEnkey" ;

            System.out.println("Original Text  : "+plainText);
            
            byte[] cipherText = encrypt(plainText.getBytes("windows-1256"),key);
            StringBuilder s = new StringBuilder();
            
            char[] charArr = new char[cipherText.length];
            for(int i =0;i<cipherText.length;i++){
                charArr[i] = (char) Byte.toUnsignedInt(cipherText[i]);
                System.err.print(" , byte "+cipherText[i] +" char "+charArr[i]);
            }
            
            String fin = new String(charArr);
            s.append(charArr);
//            char[] charArr2 = new char[cipherText.length];
            for(int i =0;i<cipherText.length;i++){
                Byte bb = cipherText[i];
//                bb.
                String vv = Byte.toString(cipherText[i]);
                String vv2 = Byte.toString(cipherText[i]);
                System.err.print(" , string "+vv);
                System.err.print(" , string "+vv);
            }
            System.err.println("final String "+fin);
            
            System.out.println("String(cipherText,\"US-ASCII\")   "+new String(cipherText,"US-ASCII") );
            System.out.println("String(cipherText,\"ISO-8859-1\") "+new String(cipherText,"ISO-8859-1") );
            System.out.println("String(cipherText,\"UTF-8\")      "+new String(cipherText,"UTF-8") );
            System.out.println("String(cipherText,\"UTF-16BE\")   "+new String(cipherText,"UTF-16BE") );
            System.out.println("String(cipherText,\"UTF-16LE\")   "+new String(cipherText,"UTF-16LE") );
            System.out.println("String(cipherText,\"UTF-16\")     "+new String(cipherText,"UTF-16") );
            
            System.out.println("String(cipherText,\"windows-1256\")     "+new String(cipherText,"windows-1256") );
            

            
            
            String v = new String(cipherText,"windows-1256");
//            byte[] byteArr = null;
//            char[] charArr = new char[cipherText.length];
//            for(int i =0;i<cipherText.length;i++){
//                charArr[i] = (char) Byte.toUnsignedInt(cipherText[i]);
//                System.err.print(" , byte "+cipherText[i] +" char "+charArr[i]);
//            }
//            String fin = new String(charArr);
//            System.err.println("final String "+fin);
//            
//            byte xx = (byte)charArr[0];
            byte[] enc = Base64.getEncoder().encode(cipherText);
            byte[] dec = Base64.getDecoder().decode(enc);
            
            
            
//            System.err.println(new String(enc));
//            System.err.println(new String(dec));
//            printBytes(enc);
//            printBytes(dec);
            
            String vcvc = new String(cipherText,"windows-1256");
            String decryptedText = new String(decrypt(cipherText,key),"windows-1256");
            System.out.println("DeCrypted Text : "+decryptedText);
            
            String xxz = new String(decrypt(vcvc.getBytes("windows-1256"),key),"windows-1256");
            System.out.println("DeCrypted Text : "+xxz);
            
//            String decryptedText22 = new String(decrypt(fin.getBytes("US-ASCII"),key),"windows-1252");
//            System.out.println("DeCrypted Text : "+decryptedText22);
            
//            printBytes(plainText.getBytes("windows-1252"));
//            printBytes(decryptedText.getBytes("windows-1252"));
            
            Integer c = new Integer(50);
            EncryptionUtil.testPassBy(c);
            System.err.println("after "+c.intValue()); 
            
        }
        
        public static byte[] encrypt (byte[] plainText,String encryptionKey) throws Exception{
            
            byte[] cipherText = null;
            
            if( plainText !=null && encryptionKey !=null){
                //Get Cipher Instance
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                
                //Create SecretKeySpec
                //this block generates a symmetric key for AES algorithm
                SecretKeySpec keySpec =  new SecretKeySpec(encryptionKey.getBytes("US-ASCII"), "AES");
    
                // Generating IV.
                byte[] IV = "gulfTeamAttegabi".getBytes("US-ASCII");
                
                //Create IvParameterSpec
                IvParameterSpec ivSpec = new IvParameterSpec(IV);
                
                //Initialize Cipher for ENCRYPT_MODE
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
                
                //Perform Encryption and decode the result to Base64
                cipherText = cipher.doFinal(plainText);
                
            }
            return cipherText;
        }
        
        public static byte[] decrypt (byte[] cipherText, String encryptionKey) throws Exception
        {
            
            byte[] plainText = null;
            
            if( cipherText !=null && encryptionKey !=null){
                //Get Cipher Instance
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                
                //Create SecretKeySpec
                SecretKeySpec keySpec = new SecretKeySpec(encryptionKey.getBytes("US-ASCII"), "AES");
                
                //Create IvParameterSpec
                
                IvParameterSpec ivSpec = new IvParameterSpec("gulfTeamAttegabi".getBytes("US-ASCII"));
                
                //Initialize Cipher for ENCRYPT_MODE
                cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
                
                //Perform Decryption
                plainText = cipher.doFinal(cipherText);                
            }
            return plainText;
        }
    
    
        private static void testPassBy(Integer ob){
            Integer x = new Integer(100);
            ob = x;
        }


    public String encryptAndEncodeStr(String decodedString){

        String encryptedString = encryptString(decodedString);
        String encodedString = Base64.getEncoder().encodeToString(encryptedString.getBytes());

        return encodedString;

    }

    public String decodeAndDecryptStr(String encodedString){

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        String decryptedString = decryptString(decodedString);

        return decryptedString;

    }


    public String encryptString(String plainText){
        byte[] cipherBytes  = null;
        String cipherString = null;
        try {
            cipherBytes = EncryptionUtil.encrypt(plainText.getBytes("windows-1256"), encryptionKey);
            if(cipherBytes != null){
                cipherString =  new String(cipherBytes,"windows-1256");
            }
        } catch (Exception e) {
            cipherString =null;
        }
        return cipherString;
    }

    public String decryptString(String cipherString){
        byte[] plainBytes  = null;
        String plainText = null;
        try {
            plainBytes = EncryptionUtil.decrypt(cipherString.getBytes("windows-1256"), encryptionKey);
            if(plainBytes != null){
                plainText =  new String(plainBytes,"windows-1256");
            }
        } catch (Exception e) {
            plainText =null;
        }
        return plainText;
    }
}
