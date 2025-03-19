//package org.expert.frequent_apis.text_format
//
//import org.expert.jdk_tools.IpV4OrV6Demo
//import spock.lang.Specification
//
//class ipV4Test extends Specification {
//
//
//    def "ipv4 输入:[#input] --> 返回:[#expect]"() {
//        expect: "find result"
//        IpV4OrV6Demo.isValidIpv4ByJDK(input) == expect
//
//        where: "result"
//        input         || expect
//        "192.169.9.0" || true
//        "::"          || false
//    }
//}
