package ru.samsungitacademy;

public class MyThread extends Thread {
    private String message;
    public boolean flag = true;

    MyThread(String mess ) {
        this.message = mess;
    }
    @Override
    public void run() {
        while(flag) {
            Main.test(message);
        }
    }
}
