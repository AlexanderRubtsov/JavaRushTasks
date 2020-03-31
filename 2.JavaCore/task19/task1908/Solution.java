package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(secondFileName));
        Pattern p = Pattern.compile("\\d+");
        StringBuilder sb = new StringBuilder();
        while (reader.ready()){
            sb.append(reader.readLine());
            sb.append(" ");
        }
        reader.close();
        String s = sb.toString();
        sb.setLength(0);
        for (String string: s.split(" ")
             ) {
            Matcher matcher = p.matcher(string);
            if (matcher.matches()) {
                sb.append(string);
                sb.append(" ");
            }
        }
//        sb.substring(0,sb.length()-2);
        writer.write(String.valueOf(sb));
        writer.close();
    }
}
