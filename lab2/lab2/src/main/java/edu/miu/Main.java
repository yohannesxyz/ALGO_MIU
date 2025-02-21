package edu.miu;

import java.util.*;

public class Main {
     public static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;
    }

    public static List<Set<Integer>> powerSet(List<Integer> X) {
        List<Set<Integer>> P = new ArrayList<>();
        P.add(new HashSet<>());

        for (int f : X) {
            List<Set<Integer>> newSubsets = new ArrayList<>();
            for (Set<Integer> subset : P) {
                Set<Integer> T = new HashSet<>(subset);
                T.add(f);
                newSubsets.add(T);
            }
            P.addAll(newSubsets);
        }

        return P;
    }

    public static void main(String[] args) {
        List<Integer> X = List.of(1,2,3,4,5);
        List<Set<Integer>> powerSet = powerSet(X);
        System.out.println(powerSet);

//        int[] arr1 = {1, 4, 5, 8, 17};
//        int[] arr2 = {2, 4, 8, 11, 13, 21, 23, 25};
//        int[] result = merge(arr1, arr2);
//        System.out.println(Arrays.toString(result));
    }
}