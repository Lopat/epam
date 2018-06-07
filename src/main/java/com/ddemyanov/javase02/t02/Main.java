package com.ddemyanov.javase02.t02;

import com.ddemyanov.javase02.t02.employees.Boss;
import com.ddemyanov.javase02.t02.employees.Employee;
import com.ddemyanov.javase02.t02.stationery.Pen;
import com.ddemyanov.javase02.t02.stationery.Pencil;
import com.ddemyanov.javase02.t02.stationery.Ruler;
import com.ddemyanov.javase02.t02.stationery.Stapler;
public class Main {


    public static void main(String[] args) {
        Employee boss = new Boss();
        boss.addStationery(new Pen(32, "penProd"),
                        new Pencil(12, "pencilProd"),
                        new Ruler(10, "rulerCo"),
                        new Stapler(50, "stapler&Co"));

        System.out.println(boss.getStationeryPrice());
    }
}
