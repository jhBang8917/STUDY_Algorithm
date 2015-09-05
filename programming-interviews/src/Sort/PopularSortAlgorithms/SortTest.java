package Sort.PopularSortAlgorithms;

import java.util.Arrays;

/**
 * Created by jhbang on 2015. 9. 5..
 */
public class SortTest {

    // logic to sort the elements
    public static void bubbleSort(int[] input) {
        int n = input.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (input[i] > input[k]) {
                    swapNumbers(i, k, input);
                }
            }
        }
    }

    public static void selectionSort(int[] input){

        for (int i = 0; i < input.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < input.length; j++)
                if (input[j] < input[index])
                    index = j;

            int smallerNumber = input[index];
            input[index] = input[i];
            input[i] = smallerNumber;
        }
    }

    public static void insertionSort(int[] input){

        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
    }



    private static void quickSort(int[] input, int lowerIndex, int higherIndex) {
        if (input == null || input.length == 0) {
            return;
        }


        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = input[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swapNumbers(i, j, input);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(input, lowerIndex, j);
        if (i < higherIndex)
            quickSort(input, i, higherIndex);
    }


    public static void mergeSort(int input[], int temp[], int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            mergeSort(input, temp, lowerIndex, middle);
            // Below step sorts the right side of the array
            mergeSort(input, temp, middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(input, temp, lowerIndex, middle, higherIndex);
        }
    }

    private static void mergeParts(int[] input, int[] temp, int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp[i] = input[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (temp[i] <= temp[j]) {
                input[k] = temp[i];
                i++;
            } else {
                input[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            input[k] = temp[i];
            k++;
            i++;
        }

    }

    /*
    * 혼합알고리즘구현해보
    * */


    private static void swapNumbers(int i, int j, int[] array) {

        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        
        final int num = 10000;
        
        long startTime;
        long stopTime;
        long elapsedTime;

        int[] input = new int[num];
        for (int i = 0; i < input.length; i++) {
            input[i]=(int)(Math.random()*num);
        }
        startTime = System.currentTimeMillis();
        bubbleSort(input);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime-startTime;
        System.out.println("버블 정렬 시간  :"+ elapsedTime);

        for (int i = 0; i < input.length; i++) {
            input[i]=(int)(Math.random()*num);
        }
        startTime = System.currentTimeMillis();
        selectionSort(input);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime-startTime;
        System.out.println("선택 정렬 시간  :"+ elapsedTime);

        for (int i = 0; i < input.length; i++) {
            input[i]=(int)(Math.random()*num);
        }
        startTime = System.currentTimeMillis();
        insertionSort(input);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime-startTime;
        System.out.println("삽입 정렬 시간  :"+ elapsedTime);

        for (int i = 0; i < input.length; i++) {
            input[i]=(int)(Math.random()*num);
        }
        startTime = System.currentTimeMillis();
        quickSort(input, 0, input.length - 1);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime-startTime;
        System.out.println("퀵 정렬 시간  :" + elapsedTime);

        for (int i = 0; i < input.length; i++) {
            input[i]=(int)(Math.random()*num);
        }
        int temp[] = new int[input.length];
        startTime = System.currentTimeMillis();
        mergeSort(input, temp, 0, input.length - 1);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime-startTime;
        System.out.println("병합 정렬 시간 :" + elapsedTime);
    }
}
