package edu.miu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int gcd(int a, int b) {
        //instantiating a variable to store the gcd
        int x = 1;
        //loop until the least element of the two is reached
        for (int i = 1; i <= (a < b ? a : b); i++) {
            if (a % i == 0 && b % i == 0) {
                //when a common divisor is found save it to the variable x
                x = i;
            }
        }
        return x;
    }

        public static List<Integer> subsetSum(List<Integer> S, int k) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>()); // Start with the empty subset
            for (int num : S) {
                List<List<Integer>> newSubsets = new ArrayList<>();

                for (List<Integer> subset : subsets) {
                    List<Integer> newSubset = new ArrayList<>(subset);
                    newSubset.add(num);

                    // Check if this new subset sums to k
                    if (newSubset.stream().mapToInt(Integer::intValue).sum() == k) {
                        return newSubset;
                    }

                    newSubsets.add(newSubset);
                }

                subsets.addAll(newSubsets); // Add new subsets to the list
            }
            return null; // No subset found
        }

        public static void main(String[] args) {
            System.out.println(gcd(9, 6));
            List<Integer> S = Arrays.asList(3, 34, 4, 12, 5, 2);
            int k = 9;
            List<Integer> subset = subsetSum(S, k);
            System.out.println(subset != null ? "Subset found: " + subset : "No subset found");
        }

}