package com.ddemyanov.javase01.t05;

public class MatrixBuilder {

    public int[][] build(int size) {

        int[][] matrix = new int[size][size];

        for(int x = 0; x < size; x++){

            for(int y = 0; y < size; y++){

                if((x == y) || (x == size - y - 1)){

                    matrix[x][y] = 1;
                }
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();   //перенос строки
        }
        return matrix;
    }

}
