package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length!=0){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        while (fileReader.ready()) {
            String fileLine = fileReader.readLine();
            String fileId = fileLine.substring(0,8);
            fileId = fileId.trim();
            map.put(fileId,fileLine);
        }
        fileReader.close();
        if (args.length!=0 && args[0].equals("-u")){
            String updateLine = String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]);
            map.put(args[1], updateLine);
        }
        if (args.length!=0 && args[0].equals("-d")) {
            System.out.println(map.containsKey(args[1]));
            map.remove(args[1].trim());

        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        for (Map.Entry<String,String> pair: map.entrySet()
             ) {
            writer.write(pair.getValue());
            writer.newLine();
            writer.flush();
        }
        writer.close();
    }
}
}
