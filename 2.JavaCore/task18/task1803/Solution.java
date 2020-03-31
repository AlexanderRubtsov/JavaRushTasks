package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePut = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filePut);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int current = fileInputStream.read();
            if (!map.containsKey(current)) map.put(current, 1);
                else {
                    map.put(current, map.get(current) + 1);
                }
        }
        fileInputStream.close();
        reader.close();
        int number = Collections.max(map.values());
        String s = "";
        for (Map.Entry<Integer, Integer> pair: map.entrySet()
             ) {
            if (pair.getValue() == number)
                s += pair.getKey() + " ";
        }
        String a = s.substring(0, s.length()-1);
        System.out.println(a);
    }
}
