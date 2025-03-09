package edu.miu;

import java.util.Arrays;

public class ThreeValueSort {
    public static void sort(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: // Swap arr[low] and arr[mid]
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:    // No swap needed, just move mid pointer
                    mid++;
                    break;
                case 2:  // Swap arr[mid] and arr[high]
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }}}
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 1, 0, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
