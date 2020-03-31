package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(firstFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFile));
        while (reader.ready()){
            String s = reader.readLine();
            writer.write(s.replace('.','!'));
        }
        reader.close();
        writer.close();
    }
}
