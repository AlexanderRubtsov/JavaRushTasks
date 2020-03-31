package com.javarush.task.task14.task1421;

public class Singleton {
    private static int singleCount = 1;
    private static Singleton instance;
    private Singleton(){
        singleCount++;
    }
    public static Singleton getInstance(){
       if(singleCount == 1) instance = new Singleton();
       return instance;
    }
}
