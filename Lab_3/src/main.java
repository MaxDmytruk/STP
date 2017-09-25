import java.util.*;

public class main {

    static final int ARRAY_LENGTH = 150;
    static final int BYTES_IN_MEGABYTE = 1048576;

    public static void main(String[] args) {
        int[] array = generateArray(ARRAY_LENGTH);
        showArray(array);

        /*int[] bubleSortedArray = bubleSort(array);
        showArray(bubleSortedArray);

        int[] heap = makeHeap(generateHeapArray(array));
        showArray(heapSort(heap));

        int[] anotherArray = cloneArray(array);
        int[] quickSortedArray = quickSort(anotherArray, 0, array.length - 1);
        showArray(quickSortedArray);

        int[] combSortedArray = combSort(array);
        showArray(combSortedArray);

        int[] coctailSortedArray = coctailSotr(array);
        showArray(coctailSortedArray);

        int[] collectionSortedArray = arraySort(array);
        showArray(collectionSortedArray);

        QuickSort notMyQuickSort = new QuickSort();
        int[] clonnedArray = cloneArray(array);
        notMyQuickSort.sort(clonnedArray);
        showArray(clonnedArray);*/

        measureMemory(array);
    }

    private static void measureTime(int[] array){
        long startTime, finishTime, measureTimeInNanoSeconds;
        double measureTimeInSeconds;

        startTime = System.nanoTime();
        bubleSort(array);
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Buble sort: " + measureTimeInSeconds);

        startTime = System.nanoTime();
        heapSort(makeHeap(generateHeapArray(array)));
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Heap sort: " + measureTimeInSeconds);

        startTime = System.nanoTime();
        int[] anotherArray = cloneArray(array);
        quickSort(anotherArray, 0, array.length - 1);
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Quick sort: " + measureTimeInSeconds);

        startTime = System.nanoTime();
        combSort(array);
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Comb sort: " + measureTimeInSeconds);

        startTime = System.nanoTime();
        coctailSort(array);
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Comb sort: " + measureTimeInSeconds);

        startTime = System.nanoTime();
        arraySort(array);
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Arrays.sort() sort: " + measureTimeInSeconds);

        QuickSort notMyQuickSort = new QuickSort();
        int[] clonnedArray = cloneArray(array);
        startTime = System.nanoTime();
        notMyQuickSort.sort(clonnedArray);
        finishTime = System.nanoTime();
        measureTimeInNanoSeconds = finishTime - startTime;
        measureTimeInSeconds = nanoSecondsInSeconds(measureTimeInNanoSeconds);
        System.out.println("Not my quick sort: " + measureTimeInSeconds);
    }

    private static void measureMemory(int[] array){
        long startMemory, finishMemory, resultMemory;
        double resultMBytes;

        startMemory = Runtime.getRuntime().freeMemory();
        bubleSort(array);
        finishMemory = Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Buble sort: " + resultMBytes);

        startMemory = Runtime.getRuntime().freeMemory();
        heapSort(makeHeap(generateHeapArray(array)));
        finishMemory = Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Heap sort: " + resultMBytes + "Mb");

        startMemory = Runtime.getRuntime().freeMemory();
        int[] anotherArray = cloneArray(array);
        quickSort(anotherArray, 0, array.length - 1);
        finishMemory = Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Quick sort: " + resultMBytes + "Mb");

        startMemory = Runtime.getRuntime().freeMemory();
        combSort(array);
        finishMemory = Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Comb sort: " + resultMBytes + "Mb");

        startMemory = Runtime.getRuntime().freeMemory();
        coctailSort(array);
        finishMemory = Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Comb sort: " + resultMBytes + "Mb");

        startMemory = Runtime.getRuntime().freeMemory();
        arraySort(array);
        finishMemory = Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Arrays.sort() sort: " + resultMBytes + "Mb");

        QuickSort notMyQuickSort = new QuickSort();
        int[] clonnedArray = cloneArray(array);
        startMemory = Runtime.getRuntime().freeMemory();
        notMyQuickSort.sort(clonnedArray);
        finishMemory = Runtime.getRuntime().freeMemory();
        resultMemory = finishMemory - startMemory;
        resultMBytes = bytesToMBytes(resultMemory);
        System.out.println("Not my quick sort: " + resultMBytes + "Mb");
    }

    private static double bytesToMBytes(long bytes){
        return bytes / BYTES_IN_MEGABYTE;
    }

    private static double nanoSecondsInSeconds(long nano){
        return nano * Math.pow(10, -9);
    }

    private static void showArray(int[] arrayToShow) {
        for (int item : arrayToShow) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static int[] generateArray(int arrayLength) {
        Random random = new Random();
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }

    private static int[] generateHeapArray(int[] array){
        int[] heapArray = new int[array.length + 1];
        heapArray[0] = 0;
        for (int i = 1; i < heapArray.length; i++){
            heapArray[i] = array[i - 1];
        }
        return heapArray;
    }

    private static int[] bubleSort(int[] arrayToSort) {
        int[] sortedArray = cloneArray(arrayToSort);

        for (int j = 0; j < sortedArray.length; j++) {
            boolean hasChanges = false;
            for (int i = 1; i < sortedArray.length; i++) {
                if (sortedArray[i - 1] > sortedArray[i]) {
                    sortedArray[i] += sortedArray[i - 1];
                    sortedArray[i - 1] = sortedArray[i] - sortedArray[i - 1];
                    sortedArray[i] -= sortedArray[i - 1];
                    hasChanges = true;
                }
            }
            if (!hasChanges)
                break;
        }
        return sortedArray;
    }

    private static int[] heapSort(int[] heap){
        int[] sortedHeap = heap;
        while (sortedHeap[0] > 0) {
            int temp = sortedHeap[1];
            sortedHeap[1] = sortedHeap[sortedHeap[0]];
            sortedHeap[sortedHeap[0]] = temp;

            for (int i = 1; i < sortedHeap[0]; i++) {
                int index = i;

                while (sortedHeap[index / 2] < sortedHeap[index] && (index / 2) != 0) {
                    int temp2 = sortedHeap[index / 2];
                    sortedHeap[index / 2] = sortedHeap[index];
                    sortedHeap[index] = temp2;
                    index /= 2;
                }
            }
            sortedHeap[0]--;
        }
        return sortedHeap;
    }

    private static int[] makeHeap(int[] array){
        int[] heapedArray = cloneArray(array);
        for (int i = 1; i < heapedArray.length; i++){
            heapedArray[0] ++;
            int index = i;

            while(heapedArray[index / 2] < heapedArray[index] && (index / 2) != 0){
                int temp = heapedArray[index / 2];
                heapedArray[index / 2] = heapedArray[index];
                heapedArray[index] = temp;
                index /= 2;
            }
        }
        return heapedArray;
    }

    private static int[] cloneArray(int[] arrayToCopy) {
        int[] clonedArray = new int[arrayToCopy.length];

        for (int i = 0; i < arrayToCopy.length; i++) {
            clonedArray[i] = arrayToCopy[i];
        }
        return clonedArray;
    }

    private static int getMdeiana(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int tmp;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    private static int[] quickSort(int[] array, int left, int right) {
        int index = getMdeiana(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {
            quickSort(array, index, right);
        }
        return array;
    }

    private static int[] combSort(int[] array) {
        int[] sortedArray = cloneArray(array);

        int length = sortedArray.length;
        int gap = length;
        boolean isSwapped = true;

        while (gap != 1 || isSwapped == true) {
            gap = getNextGap(gap);
            isSwapped = false;
            for (int i = 0; i < length - gap; i++) {
                if (sortedArray[i] > sortedArray[i + gap]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + gap];
                    sortedArray[i + gap] = temp;
                    isSwapped = true;
                }
            }
        }
        return sortedArray;
    }

    private static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    private static int[] coctailSort(int[] array) {
        int[] sortedArray = cloneArray(array);
        boolean isSwaped = true;
        int start = 0;
        int end = sortedArray.length;

        while (isSwaped) {
            isSwaped = false;
            for (int i = start; i < end - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    isSwaped = true;
                }
            }
            if (isSwaped = false)
                break;
            isSwaped = false;
            end--;
            for (int i = end - 1; i >= start; i--) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    isSwaped = true;
                }
            }
            start++;
        }
        return sortedArray;
    }

    private static int[] arraySort(int[] array){
        int[] sortedArray = cloneArray(array);
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    private static int[] intColelectionToArray(Collection<Integer> collection) {
        int[] result = new int[collection.size()];
        for (int i = 0; i < collection.size(); i++) {
            result[i] = (int) collection.toArray()[i];
        }
        return result;
    }

    private static Collection<Integer> intArrayToCollection(int[] array) {
        Collection<Integer> result = new ArrayList<>();
        for (int item : array) {
            result.add(item);
        }
        return result;
    }
}
