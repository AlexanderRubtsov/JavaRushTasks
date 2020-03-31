package com.javarush.task.task16.task1632;

import javax.naming.InterruptedNamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourthThread());
        threads.add(new FivesThread());
    }

    public static void main(String[] args) {
    }

    public static class FirstThread extends  Thread{
        @Override
        public void run() {
            while (true){}
        }
    }

    public static class SecondThread extends  Thread{
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread extends  Thread{
        @Override
        public void run() {
            while (true)
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class FourthThread extends  Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()){}
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }
    public static class FivesThread extends  Thread{
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int summa = 0;
            while (true){
                try {
                    String s =reader.readLine();
                    if (s.equals("N")){
                        System.out.println(summa);
                        break;
                    } else summa+=Integer.parseInt(s);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}