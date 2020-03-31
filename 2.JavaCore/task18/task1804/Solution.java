package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int current = fileInputStream.read();
            if (!map.containsKey(current)) map.put(current, 1);
            else map.put(current, map.get(current) + 1);
        }
        fileInputStream.close();
        reader.close();
        int min = Collections.min(map.values());
        for (Map.Entry<Integer, Integer> pair: map.entrySet()
             ) {
            if (pair.getValue() == 1) System.out.print(pair.getKey() +" ");
        }
    }
}
