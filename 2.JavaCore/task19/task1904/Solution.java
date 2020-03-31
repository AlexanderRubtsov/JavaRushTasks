package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] words = fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
//            Date date = (simpleD
            return new Person(words[1], words[2], words[0], simpleDateFormat.parse(words[3]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
