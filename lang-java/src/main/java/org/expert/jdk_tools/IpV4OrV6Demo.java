package org.expert.jdk_tools;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 通过 JDK 判断是否是 ipv4 或者 ipv6
 */
@Slf4j
public class IpV4OrV6Demo {


    public static boolean isValidIpv4ByJDK(String ip) {
        try {
            InetAddress byName = Inet4Address.getByName(ip);
            return byName instanceof Inet4Address;
        } catch (UnknownHostException ex) {
            System.out.println("Invalid IP address" + ip);
            return false;
        }
    }

    @Test
    public void test_Ip() {
        //        String ip = "49.93.128.173";
        String ip = "fe80:acc2:e1ff:fe9d:f5ec";
        InetAddress byName;
        try {
            byName = InetAddress.getByName(ip);
            System.out.println("byName = " + byName);
            boolean isV4 = byName instanceof Inet4Address;
            System.out.println("isV4 = " + isV4);
            boolean isV6 = byName instanceof Inet6Address;
            System.out.println("isV6 = " + isV6);
        } catch (UnknownHostException ex) {
            log.error("ex", ex);
        }
    }
}
