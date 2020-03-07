package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream outputStream = null;
        SortedMap<Integer ,byte[]> parts = new TreeMap<>();
        String mainFileName = "";
        while (true){
            String fileName = reader.readLine();
            if (fileName.equals("end")) break;
            mainFileName = fileName.substring(0,fileName.lastIndexOf('.'));
//            System.out.println(mainFileName);
            String numberPart = fileName.substring(fileName.lastIndexOf('t')+1);
//           System.out.println(numberPart);
            int numberPartInt = Integer.parseInt(numberPart);
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            byte[] bytes = new byte[inputStream.available()];
            while (inputStream.available()>0){
                inputStream.read(bytes);
                parts.put(numberPartInt, bytes);
            }
            inputStream.close();
        }
        outputStream = new BufferedOutputStream(new FileOutputStream(new File(mainFileName)));
        for (Map.Entry<Integer, byte[]> pair: parts.entrySet()){
                outputStream.write(pair.getValue());
        }
        outputStream.close();
    }
}
