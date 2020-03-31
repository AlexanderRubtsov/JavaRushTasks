package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(firstFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(secondFileName);
        ArrayList<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0){
            list.add(fileInputStream.read());
        }
        Collections.reverse(list);
        for (Integer x: list
             ) {
            fileOutputStream.write(x);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
