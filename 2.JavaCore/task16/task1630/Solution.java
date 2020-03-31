package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String result ="";
        BufferedReader reader;

        @Override
        public void setFileName(String fullFileName) {
            try {
                 reader = new BufferedReader(new FileReader(fullFileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Файл не найден!");
            }
        }

        @Override
        public void run() {
            while (true){
                try {
                    if (!reader.ready()) break;
                    result = result + " " + reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public String getFileContent() {
         if (!result.equals("")) result = result.substring(1);
            return result;
        }
    }
}
