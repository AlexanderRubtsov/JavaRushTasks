package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String,Double> treeMap = new TreeMap<>();
//        Pattern pattern = Pattern.compile("(\\D+)\\s+(\\d+\\.\\d+)");
        while (reader.ready()){
            String line = reader.readLine();
            String[] words = line.split("\\s+");
            if (!treeMap.containsKey(words[0])) treeMap.put(words[0], Double.parseDouble(words[1]));
            else treeMap.put(words[0], treeMap.get(words[0])+Double.parseDouble(words[1]));

        }
        reader.close();
        for (Map.Entry<String,Double> pair: treeMap.entrySet()
        ) {
            if (pair.getValue().equals(Collections.max(treeMap.values()))) System.out.println(pair.getKey());
        }
    }
    }
