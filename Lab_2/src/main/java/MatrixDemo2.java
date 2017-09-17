package main.java;

import java.util.Random;

public class MatrixDemo2 {
    public static void main(String[] args){
        final int MATRIX_ORDER = 10;

        int[][] matrix = createMatrix(MATRIX_ORDER);
        showMatrix(matrix);
        getResult(matrix);
    }

    private static int[][] createMatrix(int order){
        Random random = new Random();
        int[][] matrix = new int[order][order];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = random.nextInt(10) - 5;
            }
        }
        return matrix;
    }

    private static void showMatrix(int[][] matrix){
        for (int[] row : matrix){
            for (int item : row){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    private static int getSumOfRow(int[] row){
        int sum = 0;
        for (int item : row){
            sum += item;
        }
        return sum;
    }

    private static int getMaxInRow(int[] row){

        try {
            int max = row[0];
            for (int item : row) {
                if(item > max)
                    max = item;
            }
            return max;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getStackTrace());
        }
        return -99;
    }

    private static void getResult(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if((i == j) && (matrix[i][j] < 0)){
                    System.out.println("Sum of the row with " + matrix[i][j] + " item on main diagonal: " + getSumOfRow(matrix[i]));
                    System.out.println("Max element of the row with " + matrix[i][j] + " item on main diagonal: " + getMaxInRow(matrix[i]));
                }
            }
        }
    }
}
