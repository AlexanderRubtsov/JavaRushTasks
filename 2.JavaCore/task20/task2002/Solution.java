package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:\\data.txt");
            InputStream inputStream = new FileInputStream("d:\\data.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setCountry(User.Country.OTHER);
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setLastName("Lolov");
            user.setFirstName("Petya");
            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            String usersIsPresent = this.users!=null ? "Yes\n": "No\n";
            outputStream.write(usersIsPresent.getBytes());
            for (User user: users
                 ) {
                String line = user.getFirstName() +" " + user.getLastName() + " " + user.getBirthDate().getTime() + " " + user.isMale() + " " + user.getCountry().getDisplayName() + "\n";
                outputStream.write(line.getBytes());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String userIsPresent = reader.readLine();
            if (userIsPresent.equals("Yes")) {
                while (reader.ready()) {
                    String[] line = reader.readLine().split(" ");
                    User user = new User();
                    user.setFirstName(line[0]);
                    user.setLastName(line[1]);
                    user.setBirthDate(new Date(Long.parseLong(line[2])));
                    user.setMale(line[3].equals("true"));
                    switch (line[4]) {
                        case ("Ukraine"):
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case ("Russia"):
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case ("Other"):
                            user.setCountry(User.Country.OTHER);
                            break;
                    }
                    this.users.add(user);
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
