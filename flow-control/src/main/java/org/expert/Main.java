package org.expert;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Main {
    static String api_key = "PSUBZLHOKUO6HV52A5CAUSSE5KSB6Y";
    static String seq_id = "b8b4f0b8-01fb-4c06-80b9-3ab895a8c616";
    static String timestamp = "1554695343";
    static String slat = "39.998299";
    static String slon = "116.285561";

    static String api_sercret = "DZaslH9B9ycqRrE77laCPB2Om";


    public static void main(String[] args) {
        //        Map<String, String> map = new TreeMap<>();
        //        map.put("api_key", api_key);
        //        map.put("seq_id", seq_id);
        //        map.put("timestamp", timestamp);
        //        map.put("slat", slat);
        //        map.put("slon", slon);
        //        // map.put("test", null);
        //        String sortParStr = Joiner.on("&").skipNulls()
        //                .withKeyValueSeparator("=")
        //                .join(map);
        //
        //        System.out.println(sortParStr);
        //        String toMd5 = sortParStr + api_sercret;
        //        String s = md5WithSpring(toMd5);
        //        System.out.println("MD5(sortParStr) = " + s.toUpperCase());
        //        // 8A983278E5366EB93FEB0D4143E1C522
        //        // 8A983278E5366EB93FEB0D4143E1C522

        Date date = new Date();

        long time = date.getTime();
        System.out.println("date = " + date);
        System.out.println("time = " + time);
        Date date1 = new Date(time - (time % 1000));
        System.out.println("date1 = " + date1);
        long time1 = date1.getTime();
        System.out.println("time1 = " + time1);
    }

    // 使用 Spring 的工具类进行 MD5 加密
    private static String md5WithSpring(String toMd5) {
        return DigestUtils.md5DigestAsHex(toMd5.getBytes(StandardCharsets.UTF_8));
    }

}