package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(firstFileName);
        FileOutputStream fileOutputStream1 = new FileOutputStream(secondFileName);
        FileOutputStream fileOutputStream2 = new FileOutputStream(thirdFileName);
        if (fileInputStream.available() > 0){
            byte[] firstPart = new byte[fileInputStream.available() % 2 == 0 ? fileInputStream.available() / 2 : fileInputStream.available()/2 + 1];
            byte[] secondPart = new byte[fileInputStream.available() / 2];
            fileInputStream.read(firstPart);
            fileInputStream.read(secondPart);
            fileOutputStream1.write(firstPart);
            fileOutputStream2.write(secondPart);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
