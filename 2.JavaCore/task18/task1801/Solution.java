package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileTrack = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileTrack);
        int result = 0;
        while (fileInputStream.available() > 0){
            int current = fileInputStream.read();
            if (current > result) result = current;
        }
        fileInputStream.close();
        System.out.println(result);
    }
}
