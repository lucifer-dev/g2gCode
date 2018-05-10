package com.coding;

/*
Problem - To find if given number is perfect or not

Description - A perfect number is a number which has the sum of its factors equal to the number itself.

The factors of 6 are 1, 2, 3 whose sum equals 1 + 2 + 3 = 6. Hence 6 is perfect.
The factors of 4 are 1, 2 whose sum equals 1 + 2 = 3. Hence 4 is not perfect.
 */

public class PerfectNumber {

    protected int findIfPerfect(int input) {
        if (input == 0) {
            return 0;
        }
        if (findSumOfFactors(input) == input) {
            return 1;
        } else {
            return 0;
        }
    }

    protected int findSumOfFactors(int input) {
        int sumOfFactors = 0, quotient;
        for (int divisor = 1; divisor <= Math.sqrt(input); divisor++) {
            if (input % divisor == 0) {
                quotient = (input / divisor);
                if (divisor == quotient) {
                    sumOfFactors = sumOfFactors + divisor;
                } else {
                    sumOfFactors = sumOfFactors + divisor;
                    sumOfFactors = sumOfFactors + quotient;
                }
            }
        }
        sumOfFactors = sumOfFactors - input;
        return sumOfFactors;
    }
}
