package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = null;
        BufferedReader buffer = null;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String filePath = reader.readLine();
            inputStream = new FileInputStream(filePath);
            buffer =new BufferedReader (new InputStreamReader(inputStream));
            while (buffer.ready()){
                list.add(Integer.parseInt(buffer.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            reader.close();
            inputStream.close();
            buffer.close();
        }
        Collections.sort(list);
        for (Integer x:list
             ) {
            if (x % 2 == 0) System.out.println(x);
        }
    }
}
