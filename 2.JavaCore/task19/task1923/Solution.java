package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        while (reader.ready()){
            ArrayList<String> list = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            for (String word: list
                 ) {
                if (Pattern.compile("\\d+").matcher(word).find()) {
                    fileWriter.write(word +" ");
                }
            }
        }
        reader.close();
        fileWriter.close();
    }
}
