package edu.miu;

import java.util.Random;

public class Main {
    // MergeSortPlus algorithm
    public static void mergeSortPlus(int[] arr, int left, int right) {
        if (right - left + 1 <= 20) { // Threshold for switching to InsertionSort
            insertionSort(arr, left, right);
        } else {
            int mid = (left + right) / 2;
            mergeSortPlus(arr, left, mid);
            mergeSortPlus(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // Standard MergeSort algorithm
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }


    // Merge function
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        // Copy data to temp arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);
        // Merge the temp arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        // Copy remaining elements
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    // InsertionSort for small subarrays
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Test the sorting algorithms
    public static void main(String[] args) {
        // Generate random arrays for testing
        int[] smallArray = generateRandomArray(10);
        int[] mediumArray = generateRandomArray(100);
        int[] largeArray = generateRandomArray(1000);

        // Run and compare MergeSort and MergeSortPlus
        System.out.println("Testing MergeSortPlus vs MergeSort:");
        testPerformance("Small Array", smallArray.clone());
        testPerformance("Medium Array", mediumArray.clone());
        testPerformance("Large Array", largeArray.clone());
    }

    // Helper to test performance
    public static void testPerformance(String testName, int[] arr) {
        int[] mergeSortArray = arr.clone();
        int[] mergeSortPlusArray = arr.clone();
        // Test MergeSort
        long startTime = System.nanoTime();
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        long mergeSortTime = System.nanoTime() - startTime;
        // Test MergeSortPlus
        startTime = System.nanoTime();
        mergeSortPlus(mergeSortPlusArray, 0, mergeSortPlusArray.length - 1);
        long mergeSortPlusTime = System.nanoTime() - startTime;
        // Print results
        System.out.println(testName + ":");
        System.out.println("MergeSort Time: " + mergeSortTime + " ns");
        System.out.println("MergeSortPlus Time: " + mergeSortPlusTime + " ns");
        System.out.println();
    }
    // Helper to generate random arrays
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); // Random integers between 0 and 999
        }
        return arr;
    }
}