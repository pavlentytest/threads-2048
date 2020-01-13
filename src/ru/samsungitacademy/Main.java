package ru.samsungitacademy;

public class Main {

    // Класс Thread => реализуем run
    // Интерфейс Runnable => реализуем run
    // synchronized - синхронизация по объекту
    // wait() - поток в состоянии ожидания
    // notify() - возобновление потока
    // join() - ожидаем завершение потока


    public static void main(String[] args) throws InterruptedException {
	    // наследник Thread
        // имплементировать interface Runnable
        // [+][-][+][-]
        MyThread t1 = new MyThread("+");
        t1.start();
        MyThread t2 = new MyThread("-");
        t2.start();
        Thread.sleep(500);
        t2.flag = false;
       // t2.join(); // ожидание завершение потока
        Main.test("Stopped 2-d thread!");

        //new MyThread("-").start();

    }

    public static Object key = new Object();

    public static void test(String m) {
        try {
            // key - это объект по которому синхронизируются
            synchronized(key) {
                System.out.print("[");
                Thread.sleep(100);
                System.out.print(m);
                Thread.sleep(100);
                System.out.print("]");
            //    key.notify(); // возобновляем какой-то поток, который в wait
              //  key.wait(); // ставим поток в режим wait
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
