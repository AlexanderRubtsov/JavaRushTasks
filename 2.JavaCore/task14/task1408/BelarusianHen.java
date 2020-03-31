package com.javarush.task.task14.task1408;


import com.javarush.task.task14.task1408.Country;
import com.javarush.task.task14.task1408.Hen;

public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 30;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "+ Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
