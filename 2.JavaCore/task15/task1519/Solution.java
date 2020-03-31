package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = reader.readLine();
            if (s.equals("exit")) break;
            if (isDouble(s)) {
                print(Double.parseDouble(s));
                continue;
            }
            if (isNumber(s)) {
                int i = Integer.parseInt(s);
                if (i > 0 && i < 128) {
                    print((short) i);
                    continue;
                    }
                    else {
                        print (i);
                        continue;
                    }
            }
            print(s);
        }
    }
    
    public static boolean isDouble(String s){
        Pattern p = Pattern.compile("^\\-?\\d+\\.\\d+");
        Matcher m = p.matcher(s);
        return m.matches();
    }
    
    public static boolean isNumber(String s){
        Pattern p = Pattern.compile("^\\-?\\d+");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
