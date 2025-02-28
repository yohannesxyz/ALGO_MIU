package edu.miu;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static int fibonacci(int n){
        if(n==0||n==1){
            return n;
        }
        int fibPrev=0;
        int fibCurr=1;

        for(int i=2;i<=n;i++){
            int fibNext=fibPrev+fibCurr;
            fibPrev=fibNext;
            fibCurr=fibNext;
        }
        return fibCurr;
    }
    public static int[] countZerosAndOnes(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{0, 0};
        }
        // Find the boundary between 0s and 1s using binary search
        int left = 0;
        int right = A.length - 1;
        // Binary search to find the first occurrence of 1
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // At this point, 'left' is at the index of the first 1
        int countZeros = left;
        int countOnes = A.length - left;
        return new int[]{countZeros, countOnes};
    }

    public static void main(String[] args) {

        System.out.println(
                Arrays.toString(countZerosAndOnes(new int[]{0,0,0,0,1,1,1,1})));
    }
}