package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MatrixDemo {
    public static void main(String[] args){
        int[] rowsAllEven, monotonousRows;

        System.out.print("Enter order of matrix: ");
        Scanner input = new Scanner(System.in);
        int matrixOrder = getMatrixOrder();

        //int[][] matrix = new int[matrixOrder][matrixOrder];
        //int[][] matrix = createMonotonousMatrix(matrixOrder);

        try {
            int[][] matrix = createMatrix(matrixOrder);
            showMatrix(matrix);

            rowsAllEven = getAllEvenRow(matrix);
            System.out.print("Row in which all items are even: ");
            outputResult(rowsAllEven);
            monotonousRows = getMonotonuosRows(matrix);
            System.out.println("Task 2: ");
            outputResult(monotonousRows);
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }

    private static int getMatrixOrder(){
        try{
            return new Scanner(System.in).nextInt();
        }
        catch(Exception ex){
            return getMatrixOrder();
        }
    }

    private static void outputResult(int[] rows){
        if(rows.length == 0)
            System.out.println("none");
        else{
            for (int item : rows) {
                System.out.print(item);
            }
        }
    }

    private static int[][] createMatrix(int order){
        Random random = new Random();
        int[][] matrix = new int[order][order];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = random.nextInt(5);
            }
        }
        return matrix;
    }

    private static int[][] createMonotonousMatrix(int order){
        int[][] matrix = new int[order][order];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = j;
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

    private static int[] getAllEvenRow(int[][] matrix){
        List<Integer> evenRows = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++){
            if(isAllItemsEven(matrix[i]))
                evenRows.add(i);
        }
        return intListToArray(evenRows);
    }

    private static int[] intListToArray(List<Integer> list){
        int[] resultArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }

    private static boolean isAllItemsEven(int[] row){
        int firstElement = row[0];
        for (int element : row) {
            if(firstElement != element)
                return false;
        }
        return true;
    }

    private static int[] getMonotonuosRows(int[][] matrix){
        List<Integer> monotonousRows = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++){
            if (isMonotonousSequence(matrix[i])){
                monotonousRows.add(i);
            }
        }

        return intListToArray(monotonousRows);
    }

    private static boolean isMonotonousSequence(int[] array){
        if(array[0] == array[1])
            return false;
        String flag = array[0] > array[1] ? "decr" : "incr";
        for (int i = 1; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                if(flag == "incr")
                    return false;
            }
            else {
                if (flag == "decr"){
                    return false;
                }
            }
        }
        return true;
    }
}
