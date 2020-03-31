package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            int current = fileInputStream.read();
            if (!list.contains(current)) list.add(current);
        }
        fileInputStream.close();
        reader.close();
        Collections.sort(list);
        for (Integer x: list
             ) {
            System.out.print(x + " ");
        }
    }
}
