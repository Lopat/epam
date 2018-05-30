package com.ddemyanov.javase01.t03;

public class FunctionTablePrinter {

    private static double function(double x){
        return Math.tan(2 * x) - 3;
    }

    static void printTable(double pointA, double pointB, double step){

        for (    ; pointA <= pointB; pointA += step){
            System.out.println("Arg: " + pointA + " | Result: " + function(pointA));
        }
        System.out.println("that's all, folks!");
    }
}
