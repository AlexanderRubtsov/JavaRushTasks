package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "12";
            s.charAt(5);
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            int[] a = new int[3];
            int b = a[5];
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            FileInputStream file = new FileInputStream("asdsd");
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            Object sad[] = new Integer[5];
            sad[3] = "hiy";
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            Object sda = new Character('%');
            System.out.println((Byte)sda);
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            String[] s = new String[-5];
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            int[] s = null;
            int a = s.length;
        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
           throw new IllegalMonitorStateException();

        }
        catch (Exception e){
            exceptions.add(e);
        }
        try {
            throw  new ConcurrentModificationException();
        }
        catch (Exception e){
            exceptions.add(e);
        }
    }
}
