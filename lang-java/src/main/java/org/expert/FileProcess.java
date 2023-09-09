package org.expert;

public class FileProcess {
    public static void main(String[] args) {
        flow();
    }


    public static void flow() {
        String s;
        try {
            s = "hh";
            System.out.println("hh");
        } finally {
            System.out.println("finally");
        }
        System.out.println("out");
    }
}

