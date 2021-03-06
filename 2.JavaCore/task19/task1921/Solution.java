package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Pattern pattern = Pattern.compile("(\\D+)(\\d+\\s+\\d+\\s+\\d+)");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
        while (reader.ready()){
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                PEOPLE.add(new Person(matcher.group(1).trim(), simpleDateFormat.parse(matcher.group(2))));
            }
        }
        reader.close();
    }
}
