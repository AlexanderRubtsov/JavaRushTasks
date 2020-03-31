package com.javarush.task.task13.task1309;

/* 
Всё, что движется
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
    
    interface CanMove{
        Double speed();
    }
    
    interface CanFly extends CanMove {
        Double speed(CanFly eblan);
    }

    public class Petuh implements CanFly{

        @Override
        public Double speed() {
            return null;
        }

        @Override
        public Double speed(CanFly eblan) {
            return null;
        }
    }
}