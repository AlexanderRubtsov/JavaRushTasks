package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            reader.close();
            FileReader fileReader = new FileReader(firstFileName);
            FileWriter fileWriter = new FileWriter(secondFileName);
            int count = 0;
            while (fileReader.ready()){
                count++;
                int data = fileReader.read();
                if (count % 2 == 0) fileWriter.write(data);
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
