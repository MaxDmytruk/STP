package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array;

        System.out.print("Enter length of array: ");
        Scanner input = new Scanner(System.in);
        int arrayLength = getArrayLength();
        array = new int[arrayLength];

        try {
            System.out.println("Enter " + arrayLength + " element(s)");
            for (int i = 0; i < arrayLength; i++) {
                System.out.print("array[" + (i + 1) + "] = ");
                array[i] = getIntInput();
            }
            System.out.print("Array: ");
            for (int i = 0; i < arrayLength; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();

            System.out.println("Arythmetical mean of paired elements: " + getArythmeticMeanOfPaired(array));
            System.out.println("Sum of min positive and it`s digits: " + getSumOfMinNumAndDigits(array));
            System.out.println("Product of the most negative and smallest paired: " + getMinNegative(array) * getMinimumPositivePaired(array));
            System.out.println("Count of items multiple 5: " + getCountOfItemsMultipleFive(array));
            System.out.println("Sum of the paired elements of the array standing on odd places " + getSumPairedOnOddPlaces(array));
            System.out.println("Sum of the second and most positive element " + getSumOfSecondAndMostPositive(array));
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    private static int getIntInput() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (Exception ex) {
            return getArrayLength();
        }
    }

    private static int getArrayLength() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (Exception ex) {
            return getArrayLength();
        }
    }

    private static double getArythmeticMeanOfPaired(int[] elementsArray) {
        int pairedCount = 0;
        int pairedSum = 0;

        for (int element : elementsArray) {
            if (isPaired(element)) {
                pairedCount++;
                pairedSum += element;
            }
        }

        if (pairedCount == 0)
            return 0;
        return (double) (pairedSum / pairedCount);
    }

    private static boolean isPaired(int element) {
        return element % 2 == 0;
    }

    private static boolean isMultipleFive(int element) {
        return element % 5 == 0;
    }

    private static int getSumOfMinNumAndDigits(int[] array) {
        int minNumber = getMinimumPositive(array);
        int sum = 0;
        int[] digits = getNumberDigits(minNumber);
        for (int digit : digits) {
            sum += digit;
        }
        return sum + minNumber;
    }

    private static int getMinimumPositive(int[] array) {
        return getMinimum(getPositive(array));
    }

    private static int getMinimum(int[] array) {
        int min = 0;
        if (array.length != 0)
            min = array[0];
        for (int item : array) {
            if (item < min)
                min = item;
        }
        return min;
    }

    private static int[] getPositive(int[] array) {
        List<Integer> resultList = new ArrayList<Integer>();

        for (int item : array) {
            if (item > 0)
                resultList.add(item);
        }

        return intListToArray(resultList);
    }

    private static int[] getNumberDigits(int number) {
        if (number > 0) {
            if (number < 9) {
                return new int[]{number};
            } else {
                List<Integer> digits = new ArrayList<Integer>();
                while (number >= 1) {
                    digits.add((int) (number % 10));
                    number /= 10;
                }
                return intListToArray(digits);
            }
        }
        return new int[]{};
    }

    private static int[] intListToArray(List<Integer> list) {
        int[] resultArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }

    private static int getMinNegative(int[] array) {
        int min = getMinimum(array);
        if (min > 0) {
            return 0;
        } else {
            return min;
        }
    }

    private static int getMinimumPositivePaired(int[] array) {
        return getMinimum(getPositivePaired(array));
    }

    private static int[] getPositivePaired(int[] array) {
        List<Integer> paired = new ArrayList<Integer>();
        for (int item : array) {
            if (isPaired(item) && item > 0)
                paired.add(item);
        }
        return intListToArray(paired);
    }

    private static int getCountOfItemsMultipleFive(int[] array) {
        int[] arrayMultipleFive = getItemsMultipleFive(array);
        return arrayMultipleFive.length;
    }

    private static int[] getItemsMultipleFive(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int item : array) {
            if (isMultipleFive(item)) {
                list.add(item);
            }
        }
        return intListToArray(list);
    }

    private static int getSumPairedOnOddPlaces(int[] array) {
        int sum = 0;
        for (int item : getPaired(getItemsOnOddPlaces(array))) {
            sum += item;
        }
        return sum;
    }

    private static int[] getPaired(int[] array) {
        List<Integer> paired = new ArrayList<Integer>();
        for (int item : array) {
            if (isPaired(item))
                paired.add(item);
        }
        return intListToArray(paired);
    }

    private static int[] getItemsOnOddPlaces(int[] array) {
        List<Integer> oddList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 2 == 0) {
                oddList.add(array[i]);
            }
        }
        return intListToArray(oddList);
    }

    private static int getSumOfSecondAndMostPositive(int[] array) {
        if (array.length > 1) {
            return getMostPositive(array) + array[1];
        } else
            return 0;//Error
    }

    private static int getMostPositive(int[] array) {
        int max = array[0];
        for (int item : array) {
            if (max < item)
                max = item;
        }
        return max;
    }
}
