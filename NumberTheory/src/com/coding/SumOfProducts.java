package com.coding;

public class SumOfProducts {
    long calculateSumOfProducts(long stepCount, long base, long step) {
        long product = 1, iteration = 1;
        if (step == 0) {
            return 0;
        }
        while (iteration <= stepCount) {
            product = product * base;
            base = base + 1;
            iteration = iteration + 1;
        }

        if (step == stepCount) {
            return product;
        }
        return product + calculateSumOfProducts(stepCount + 1, base, step);
    }
}
