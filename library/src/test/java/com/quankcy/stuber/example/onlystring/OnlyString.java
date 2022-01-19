package com.quankcy.stuber.example.onlystring;

import com.quankcy.stuber.Car;
import com.quankcy.stuber.Mocker;
import com.quankcy.stuber.MockerSeed;
import com.quankcy.stuber.generator.RandomGenerator;

@Mocker
public class OnlyString {

    @MockerSeed(value = RandomGenerator.class)
    String someString;

    public OnlyString(){}
    public OnlyString(int no, String text, Integer number, Car car){
        Float asd;
    }

    public OnlyString(String text, int no,Integer number, Car car){
        Float asd;
    }
}
