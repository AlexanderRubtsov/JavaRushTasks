package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        char[] urlChars= URL.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        int i = 0;
        for (Character chars: urlChars){
            if (i == 1) list.add(chars);
            if (chars.equals('?'))  i = 1;
        }
        int y = 1;
        int z = 1;
        String objS ="";
        for (Character chars: list){
            if(!chars.equals('=')&& y == 1 && !chars.equals('&')) {
                System.out.print(chars);
                if (chars.equals('o') && z == 1) z = 2;
                    else if (chars.equals('b') && z == 2) z = 3;
                    else if (chars.equals('j') && z == 3) z ++;
                    else  z = 0;
            }
            if (chars.equals('=')) y = 0;
            if (chars.equals('&')) {
                y = 1;
                z = 1;
                System.out.print(" ");
            }
            if (z == 4 && y == 0 && !chars.equals('=')) objS+=chars;
        }
        System.out.println();
//        if (isDouble(objS)) alert(Double.parseDouble(objS));
//        else if (!objS.equals("")) alert(objS);
        try {
            alert(Double.parseDouble(objS));
        }
        catch(Exception e) {
            if (!objS.equals("")) alert(objS);
        }
    }
    public static boolean isDouble(String testString){
        Pattern p = Pattern.compile("^\\-?\\d+\\.\\d+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
