package edu.miu;

import java.util.Arrays;

public class BubbleSort1 {

    public static void bubbleSort(int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4};
        bubbleSort(sortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}

