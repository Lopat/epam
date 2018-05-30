package com.ddemyanov.javase01.t04;

public class FindMaxInArray {

    public static double findMax(double[] realNumbers){
        double max = 0;

        for (double num : realNumbers) {
            if (num > max)
                max = num;
        }

        return max;
    }
}
