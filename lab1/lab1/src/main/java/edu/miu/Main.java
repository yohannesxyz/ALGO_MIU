package edu.miu;

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

    public static void main(String[] args) {
        System.out.println(gcd(9, 6));
    }
}