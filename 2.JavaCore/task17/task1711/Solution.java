package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import com.javarush.task.task17.task1711.Sex;

import static com.javarush.task.task17.task1711.Person.createFemale;
import static com.javarush.task.task17.task1711.Person.createMale;





/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]){
            case ("-i"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        System.out.println(allPeople.get(Integer.parseInt(args[i])));
                    }
                    break;
                }
            case ("-c"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 2; i += 3) {
                        add(args[i], args[i + 1], args[i + 2]);
                    }
                    break;
                }
            case ("-d"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(args[i]);
                    }
                    break;
                }
            case ("-u"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 3; i += 4) {
                        update(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                    break;
                }
        }
    }

    public static void delete(String s){
        Person person = allPeople.get(Integer.parseInt(s));
        person.setBirthDate(null);
        person.setName(null);
        person.setSex(null);
    }

    public static void add(String name, String strSex, String strDate) throws ParseException {
        if (strSex.equals("м")) allPeople.add(createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(strDate)));
        if (strSex.equals("ж")) allPeople.add(createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(strDate)));
        System.out.println(allPeople.size()-1);
    }

    public static void update(String strId, String name, String strSex, String strDate) throws ParseException {
        Person person = allPeople.get(Integer.parseInt(strId));
        person.setName(name);
        person.setSex(strSex.equals("м")? Sex.MALE : Sex.FEMALE);
        person.setBirthDate(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(strDate));
    }
}
