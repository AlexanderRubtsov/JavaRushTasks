package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        while (reader.ready()){
            list1.add(reader.readLine());
        }
        reader.close();
        while (reader2.ready()){
            list2.add(reader2.readLine());
        }
        reader2.close();
       while (true){
           if (list1.size()==0 && list2.size()==0) break;
           if (list1.size()==1 && list2.size()==0) {
               lines.add(new LineItem(Type.REMOVED, list1.get(0)));
               break;
           }
           if (list1.size()==0 && list2.size()==1) {
               lines.add(new LineItem(Type.ADDED, list2.get(0)));
               break;
           }
           if (list1.get(0).equals(list2.get(0))){
               lines.add(new LineItem(Type.SAME, list1.get(0)));
               list1.remove(0);
               list2.remove(0);
           } else if (list1.get(1).equals(list2.get(0))){
               lines.add(new LineItem(Type.REMOVED, list1.get(0)));
               list1.remove(0);
           } else if (list1.get(0).equals(list2.get(1))){
               lines.add(new LineItem(Type.ADDED, list2.get(0)));
               list2.remove(0);
           }
       }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
