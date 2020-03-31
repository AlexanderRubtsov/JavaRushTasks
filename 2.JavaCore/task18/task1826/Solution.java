package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
            String s = "d:\\data.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(s);
        fileOutputStream.write(54);
    }

}
