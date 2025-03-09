package edu.miu;

import java.util.Arrays;

public class BubbleSort2 {
    public static void bubbleSort(int[] array) {
        boolean swapped;
        int n = array.length;
        int newn;
        do {
            swapped = false;
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                    newn = i;
                }
            }
            n = newn;
        } while (swapped);
    }

    public static void main(String[] args) {

        int[] almostSortedArray = { 3, 4, 6, 1, 19};
        bubbleSort(almostSortedArray);
        System.out.println(Arrays.toString(almostSortedArray));
    }
}
