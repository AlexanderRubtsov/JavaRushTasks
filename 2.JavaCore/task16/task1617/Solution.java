package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            while (true){
            if (numSeconds == 0) {
                System.out.println("Марш!");
                return;
            }
            else System.out.println(numSeconds);
                try {
                    Thread.sleep(1000);
                    numSeconds --;
                } catch (InterruptedException e) {
                   // e.printStackTrace();
                    System.out.println("Прервано!");
                    return;
                }

        }
        }
    }
}
