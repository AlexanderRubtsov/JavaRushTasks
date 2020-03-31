package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (reader1.ready()) {
            sb.append(reader1.readLine());
            sb.append(" ");
        }
        reader.close();
        reader1.close();
        String line = sb.toString();
        String[] lines = line.split("\\W");
        int count = 0;
        for (String word: lines
             ) {
            if (word.equals("world")) count++;
        }
        System.out.println(count);
    }
}