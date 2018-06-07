package com.ddemyanov.javase02.t02.employees;

import com.ddemyanov.javase02.t02.stationery.Stationery;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public abstract class Employee {

    ArrayList<Stationery> stationeries = new ArrayList <>();

    public int getStationeryPrice() {
        int result = 0;

        for( Stationery s : stationeries) {
            result += s.getPrice();
        }

        return result;
    }

    public void addStationery(Stationery... st){
        stationeries.addAll(Arrays.asList(st));
    }
}
