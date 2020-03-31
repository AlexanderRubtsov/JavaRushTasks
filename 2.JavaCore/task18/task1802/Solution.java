package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePut = reader. readLine();
        FileInputStream fileInputStream = new FileInputStream(filePut);
        int result = fileInputStream.read();
        while (fileInputStream.available() > 0) {
            int current = fileInputStream.read();
            if (current < result) result = current;
        }
        System.out.println(result);
        fileInputStream.close();
        reader.close();
    }
}
