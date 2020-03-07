package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 0 && args[0].equals("-c")){
        ArrayList<Integer> listId = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader inputStreamReader = new BufferedReader(new FileReader(fileName));
        while (inputStreamReader.ready()){
            String s = inputStreamReader.readLine();
            s = s.substring(0,8);
            s = s.trim();
            if (!s.equals("")) listId.add(Integer.parseInt(s));
        }
            inputStreamReader.close();
            int maxId = Collections.max(listId);
            if (args.length != 0 && args[0].equals("-c")){
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            maxId++;
            String sb = String.format("%-8s%-30s%-8s%-4s%n",maxId,args[1],args[2],args[3]);
            bufferedWriter.newLine();
            bufferedWriter.write(sb);
            bufferedWriter.close();
            //коммент
        }
    }
    }
}
