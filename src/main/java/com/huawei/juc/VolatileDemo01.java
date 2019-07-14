package com.huawei.juc;

import java.util.concurrent.TimeUnit;

class MyData {

    //int number = 0;

    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

}

public class VolatileDemo01 {

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t updated number value: " +myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            //System.out.println("======= 0");
        }

        System.out.println(Thread.currentThread().getName()+"\t int type, mission is over, num value is" + myData.number);

    }
}
