package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            reader.close();
            BufferedReader allLinesFile = new BufferedReader(new FileReader(firstFileName));
            BufferedReader forRemoveFile = new BufferedReader(new FileReader(secondFileName));
            while (allLinesFile.ready()) {
                allLines.add(allLinesFile.readLine());
            }
            while (forRemoveFile.ready()) {
                forRemoveLines.add(forRemoveFile.readLine());
            }
            Solution solution = new Solution();
            solution.joinData();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
       if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
       else {
           allLines.clear();
           throw new CorruptedDataException();
       }
    }
}
