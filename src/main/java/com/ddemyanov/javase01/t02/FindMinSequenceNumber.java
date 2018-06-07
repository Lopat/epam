package com.ddemyanov.javase01.t02;

public class FindMinSequenceNumber {

    private double sequenceFunction(int n) {
        return (1 / Math.pow(n + 1, 2));
    }

    public void findMinimal(double e) {
        double min;
        int counter = 1;

        while (true) {

            min = sequenceFunction(counter);

            if (min < e) {
                System.out.println("Minimal number is: " + min + " Sequence index is: " + counter);
                break;
            } else
                System.out.println(min);

            counter++;
        }
    }
}
