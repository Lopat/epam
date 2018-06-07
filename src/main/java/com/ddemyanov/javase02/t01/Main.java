package com.ddemyanov.javase02.t01;

public class Main {

    public static void main(String[] args) {
        Pen p = new Pen("penCo", Pen.InkColor.BLACK);
        Pen x = new Pen("penCo", Pen.InkColor.BLUE);
        System.out.println("HashCOde: " + p.hashCode());
        System.out.println(p);
        System.out.println(p.equals(x));
    }
}