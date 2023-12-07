package org.expert.jdk_tools;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 通过 JDK 判断是否是 ipv4 或者 ipv6
 */
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
}
