package org.expert;

public class Main {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        System.out.println("end");
    }
}

class MyThread extends Thread {
    private int i = 1;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }
}
