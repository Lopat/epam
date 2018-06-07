package com.ddemyanov.javase02.t04;

import com.ddemyanov.javase02.t02.stationery.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static Comparator<Stationery> compareByPrice =  new Comparator <Stationery>() {
        @Override
        public int compare(Stationery s1, Stationery s2) {
            return s1.getPrice() - s2.getPrice();
        }
    };

    static Comparator<Stationery> compareByName =  new Comparator <Stationery>() {
        @Override
        public int compare(Stationery s1, Stationery s2) {
            return s1.getProducerName().compareTo(s2.getProducerName());
        }
    };

    static Comparator<Stationery> compareByPriceAndName =  new Comparator <Stationery>() {
        @Override
        public int compare(Stationery s1, Stationery s2) {
            return s1.getPrice() - s2.getPrice();
        }
    }.thenComparing(compareByName);




    static void printList(ArrayList<Stationery> list) {
        for(Stationery s : list){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        ArrayList<Stationery> tools = new ArrayList <>();
        tools.add(new Pen(30, "pilot"));
        tools.add(new Pen(5, "line"));
        tools.add(new Pen(44, "parker"));
        tools.add(new Pencil(5, "karandashCo"));
        tools.add(new Pencil(4, "pencilZ"));
        tools.add(new Pencil(7, "officeTools"));
        tools.add(new Ruler(7, "rulZCompany"));
        tools.add(new Ruler(16, "measurEEverything"));
        tools.add(new Ruler(10, "Zrule42"));
        tools.add(new Stapler(22, "StapleMe"));
        tools.add(new Stapler(24, "StapleMe"));
        tools.add(new Stapler(22, "AIdunno"));

        Collections.sort(tools, compareByPrice);
        printList(tools);
        System.out.println("==========================================");

        Collections.sort(tools, compareByName);
        printList(tools);
        System.out.println("==========================================");

        Collections.sort(tools, compareByPriceAndName);
        printList(tools);

    }
}
