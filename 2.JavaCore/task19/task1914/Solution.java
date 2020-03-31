package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultSystem = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(defaultSystem);
        TestString.takeChanges(outputStream.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }

        private static void takeChanges(String inputString){
            Pattern pattern = Pattern.compile("(\\d+)\\s*([+\\-*])\\s*(\\d+)\\s*=");
            Matcher matcher = pattern.matcher(inputString);
            while (matcher.find()) {
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(3));
                int c = 0;
                switch (matcher.group(2)) {
                    case ("+"):
                        c = a + b;
                        break;
                    case ("-"):
                        c = a - b;
                        break;
                    case ("*"):
                        c = a * b;
                        break;
                }
                String result = String.format("%d %s %d = %d\r\n", a, matcher.group(2), b, c);
                System.out.println(result);
            }
        }
    }

}

