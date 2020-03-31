package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(firstFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFile));
        while (reader.ready()){
            writer.write(reader.readLine().replaceAll("[\\W&&\\S]", ""));
        }
        reader.close();
        writer.close();
    }
}
