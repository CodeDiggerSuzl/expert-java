package org.expert.regex;

public class RegexDemo {

    public static void main(String[] args) {
        System.out.println("isValidTime(\"2022-10-13 12:12:12\") = " + isValidTime("2022-20-13 12:12:70"));
    }


    public static boolean isValidTime(String s) {
        return s.matches("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]");
    }

}
