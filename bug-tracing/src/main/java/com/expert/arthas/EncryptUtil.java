package com.expert.arthas;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


@Slf4j
public class EncryptUtil {
    private static byte[] iv = new byte[]{22, -125, 10, -115, 39, 37, 67, -66};

    public EncryptUtil() {
    }

    //    public static String MD5(String inStr) {
    //        MessageDigest md5 = null;
    //
    //        try {
    //            md5 = MessageDigest.getInstance("MD5");
    //        } catch (Exception var8) {
    //            var8.printStackTrace();
    //            return "";
    //        }
    //
    //        char[] charArray = inStr.toCharArray();
    //        byte[] byteArray = new byte[charArray.length];
    //
    //        for (int i = 0; i < charArray.length; ++i) {
    //            byteArray[i] = (byte) charArray[i];
    //        }
    //
    //        byte[] md5Bytes = md5.digest(byteArray);
    //        StringBuffer hexValue = new StringBuffer();
    //
    //        for (int i = 0; i < md5Bytes.length; ++i) {
    //            int val = md5Bytes[i] & 255;
    //            if (val < 16) {
    //                hexValue.append("0");
    //            }
    //
    //            hexValue.append(Integer.toHexString(val));
    //        }
    //
    //        return hexValue.toString();
    //    }
    //
    //    public static String encryptDES(String encryptString) {
    //        try {
    //            IvParameterSpec zeroIv = new IvParameterSpec(iv);
    //            SecretKeySpec key = new SecretKeySpec(iv, "DES");
    //            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    //            cipher.init(1, key, zeroIv);
    //            byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
    //            return bytesToHexString(encryptedData);
    //        } catch (Exception var5) {
    //            var5.printStackTrace();
    //            return "";
    //        }
    //    }
    //
    //    public static String encryptDES(String encryptString, String encryptKey) {
    //        try {
    //            IvParameterSpec zeroIv = new IvParameterSpec(encryptKey.substring(0, 8).getBytes());
    //            SecretKeySpec key = new SecretKeySpec(encryptKey.substring(0, 8).getBytes(), "DES");
    //            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    //            cipher.init(1, key, zeroIv);
    //            byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
    //            return bytesToHexString(encryptedData);
    //        } catch (Exception var6) {
    //            var6.printStackTrace();
    //            return "";
    //        }
    //    }
    //
    //    public static String decryptDES(String decryptString) {
    //        try {
    //            IvParameterSpec zeroIv = new IvParameterSpec(iv);
    //            SecretKeySpec key = new SecretKeySpec(iv, "DES");
    //            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    //            cipher.init(2, key, zeroIv);
    //            byte[] decryptedData = cipher.doFinal(hexStringToBytes(decryptString));
    //            return new String(decryptedData);
    //        } catch (Exception var5) {
    //            var5.printStackTrace();
    //            return "";
    //        }
    //    }
    //
    //    public static String decryptDES(String decryptString, String decryptKey) throws Exception {
    //        IvParameterSpec zeroIv = new IvParameterSpec(iv);
    //        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
    //        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    //        cipher.init(2, key, zeroIv);
    //        byte[] decryptedData = cipher.doFinal(hexStringToBytes(decryptString));
    //        return new String(decryptedData);
    //    }
    //
    //    public static String bytesToHexString(byte[] bs) {
    //        StringBuffer sb = new StringBuffer();
    //        String hex = "";
    //
    //        for (int i = 0; i < bs.length; ++i) {
    //            hex = Integer.toHexString(bs[i] & 255);
    //            if (hex.length() == 1) {
    //                hex = '0' + hex;
    //            }
    //
    //            sb.append(hex);
    //        }
    //
    //        return sb.toString().toUpperCase();
    //    }
    //
    //    public static byte[] hexStringToBytes(String in) {
    //        byte[] arrB = in.getBytes();
    //        int iLen = arrB.length;
    //        byte[] arrOut = new byte[iLen / 2];
    //
    //        for (int i = 0; i < iLen; i += 2) {
    //            String strTmp = new String(arrB, i, 2);
    //            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
    //        }
    //
    //        return arrOut;
    //    }
    //
    //    public static String encryptDESBase64(String encryptString, String encryptKey) {
    //        try {
    //            IvParameterSpec zeroIv = new IvParameterSpec(encryptKey.substring(0, 8).getBytes());
    //            SecretKeySpec key = new SecretKeySpec(encryptKey.substring(0, 8).getBytes(), "DES");
    //            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    //            cipher.init(1, key, zeroIv);
    //            byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
    //            return Base64.encodeBase64String(encryptedData);
    //        } catch (Exception var6) {
    //            var6.printStackTrace();
    //            return "";
    //        }
    //    }

    public static String decryptDESBase64(String decryptString, String decryptKey) throws Exception {
        if (StringUtils.isBlank(decryptString)) {
            return decryptString;
        } else {
            String subStr = " ";
            String replaceStr = "+";
            if (decryptString.contains(subStr)) {
                decryptString = decryptString.replaceAll(subStr, replaceStr);
            }

            byte[] byteMi = Base64.getDecoder().decode(decryptString);
            IvParameterSpec zeroIv = new IvParameterSpec(decryptKey.substring(0, 8).getBytes());
            SecretKeySpec key = new SecretKeySpec(decryptKey.substring(0, 8).getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, key, zeroIv);
            byte[] decryptedData = cipher.doFinal(byteMi);
            return new String(decryptedData);
        }
    }

    public static boolean checkVersionNew(String current_version, String target_version) {
        String[] cv = current_version.split("\\.");
        String[] tv = target_version.split("\\.");
        boolean result = true;
        int loop = Math.min(cv.length, tv.length);

        for (int i = 0; i < loop; ++i) {
            int c = Integer.parseInt(cv[i]);
            int t = Integer.parseInt(tv[i]);
            if (c > t) {
                break;
            }

            if (c < t) {
                result = false;
                break;
            }

            if (i == loop - 1 && cv.length < tv.length) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        //  String ddcinfo = "ehAq+CFEfF1m24QJA9iILqxQP8RL63CsqHQ6qdLULH0gGuE1BBetIwbu06lNP2X9e7NjmnoqosNT8Gx98WiXqEKC4SnXa+LD1uJLiSDQ1sYKBhQVPrGQgni8I7eecQbKE4ELidH0FZpeOEuZLsP42y3x0pTsF+cwK0Q9cB7sODUrnDDy4hbnz+V7lM+3MjmzwV2tFvwiafVfMssIa5fv7zV69uyqE8k30jvJB3uLCrLAzuxLguR3/YMxcJxHOKaO6X6XaQWXIWnBPVQVDymfuubsDtzG6Z6fAq2dcIWU38CYcFxX6uhXax220rGTYFfMI9bX63HoM7RBA22+0vg9BaLxn2MXp0SFGj+xlzGdSdLoFDLjRo2rXKAb64giQNnnLrIuAVo4i9mZD/9AbJu72Fxwx3IJ9Zvsv8y1ZH2MeiajwFmXtd1BQoYAD+FyzfpCa3X4grr5G6G5XLR+LP6YkRY0wgJcEkD8FZaGsOpCaeesR3X0aNmk1ZKIoBk//vyHXfzZ0oMGdCyZjB1+QRwd/dWIZMLZCuXFK+Vj/xPclUiyFbDjcH1bIq0APexDPMyp4j+ghm9zvL7wBLv75t924BWOtP3gkx36JnUlyGMhF4E1vtKA/AjArShPCejnt8MCJZrJOaX9O2aThcopH80OEv3jafUmrHEWtHt+3DDQ/SexE0bH1MT/CZNNE+x1ll3/glIAFYhai/p7rYgZayPu3J6jCVufq2Kv69PUcqI4OsoZpAa15Lo9PRTm/ZRqyAyyzkmU2dPXWTy6NtPElnarC6O8g93cvCGdiulKTo/RVhzB5cSOnGwLo+WCkBBJrpOMw1FJ0Gcj+q2rMwz5wWiuvRE9VREUmhXlE6RkFM1kwrwNQgGqZ2wPyA==";
        //  String s = EncryptUtil.decryptDESBase64(ddcinfo, "bShORr6y6EQ=");
        //  System.out.println(s);


        System.out.println("checkVersionNew(\"9.60.1\",\"9.50.1\") = " + checkVersionNew("9.60.1", "9.50.1"));
        System.out.println("checkVersionNew(\"9.60.1\",\"9.60.1\") = " + checkVersionNew("9.60.1", "9.60.1"));
        System.out.println("checkVersionNew(\"9.60.0\",\"9.60.1\") = " + checkVersionNew("9.60.0", "9.60.1"));

    }
}
