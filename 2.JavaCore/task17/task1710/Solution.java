package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args[0].equals("-i")) System.out.println(allPeople.get(Integer.parseInt(args[1])));
        if (args[0].equals("-d")) delete(args[1]);
        if (args[0].equals("-c")) add(args[1], args[2], args[3]);
        if (args[0].equals("-u")) update(args[1], args[2], args[3], args[4]);
    }

    public static void delete(String s){
        Person person = allPeople.get(Integer.parseInt(s));
        person.setBirthDate(null);
        person.setName(null);
        person.setSex(null);
    }

    public static void add(String name, String strSex, String strDate) throws ParseException {
        if (strSex.equals("м")) allPeople.add(Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(strDate)));
        if (strSex.equals("ж")) allPeople.add(Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(strDate)));
        System.out.println(allPeople.size()-1);
    }

    public static void update(String strId, String name, String strSex, String strDate) throws ParseException {
        Person person = allPeople.get(Integer.parseInt(strId));
        person.setName(name);
        person.setSex(strSex.equals("м")? Sex.MALE : Sex.FEMALE);
        person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(strDate));
    }
}
