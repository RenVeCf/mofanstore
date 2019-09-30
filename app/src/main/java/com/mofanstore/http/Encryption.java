package com.mofanstore.http;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;


public class Encryption
{
    public static void main(String args[]) throws Exception {
        System.out.println(encrypt("{\"APPUSER_ID\": \"12\",\"PAGE\": \"0\"}"));
        System.out.println(desEncrypt("L6hM9bmzAp5jER0f/shkY5a8iRx5LVMi5M9+DIIH/bLPnJjFwFh0yl7egMZXJ+XR4LN41AzLDxtw2JDyQm7YxzZee+x0rzrYbj4qm3F0f2fGfUpYO44xAe+9Ez3WQv8xEdyYANGwvF7zCVKeFuk5P429bWmspquSlLmNUE2fP55Xiaq9y0sMpKQGfp1zUdwvpItQBBlE1WbZ3wD1HndRTu2egePI1B/VogdljfQiXKjGy5wlDydLB1fxfcFAndZW5lyuhjqYQxA2OI64Qicps3DgpstHhPHOZfEhULUP6GujiNeHCx+z5sVTUsmXEaInKTikh72n0+QF2xFS9XVxFl/VOsL2qni3UZGVrvVm9xd4kr6hr1Oaf1owBqlM/4GRmxkcmWTGlcV6yFediltZ6EjWx4tHe01YdR5584ViznIIsgHLvGp4xrndueBS3W2LoNdzd/t5lIjKEqpOeJQFhK+XhC5da2i1QzKX5gQU9aZYVMBR/9+rNqgUvNRWMBroEyv1ZVem8LRVSkIUPdugCPYALpyigMlGbnZnjp6xNkpyCldcpb1mV2QQRKs8fi9VdtzIUiyR0v6xSq990YE4qvu73NMufXSXBReO93xoj0Ln8ANyM9B/IX+RoJgQTcgn5ecPPVvv/sFTiiWeyDaPaFhm2NVcry/3y8l+4YqGT2jYwZFWSN8G3gN0gaUdMSctM2H4futjhESeBvgHOAjd9QAkBMEJeVBlfbunk0Jl+gQ="));
    }
 
    public static String encrypt(String data) throws Exception {
        try {
            //String data = "123456789123456789";
            String key = "18DFCA0079F3C5D1";
            String iv = "18DFCA0079F3C5D1";
 
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            byte[] dataBytes = data.getBytes();
                      
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
 
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(dataBytes);
 
            /*BASE64编码超过76字节会自动换行*/
            return new sun.misc.BASE64Encoder().encode(encrypted).replaceAll("\r|\n", "");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    public static String desEncrypt(String data){
        try
        {
            //String data = "xqkIYv382w0bIgvrEQBqRP5wRw6uStJZiCrebpBKG9g=";
            String key = "18DFCA0079F3C5D1";
            String iv = "18DFCA0079F3C5D1";
            
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(data);
             
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
             
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
  
            byte[] original = cipher.doFinal(encrypted1);
            System.out.println(Arrays.toString(original));
            String originalString = new String(original,"UTF-8");
            return originalString;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}