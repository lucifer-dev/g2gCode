package com.coding;

/*OVERVIEW:  Given 2 integers (num1, num2), write a function that returns the count of numbers between the num1..num2 that are divisible by num1.
        E.g.: count(3, 15) returns 5 (3, 6, 9, 12, 15).
		Note : You need to consider Inclusive range
INPUTS:  Two numbers num1, num2.
		num1, num2 >= 0.

OUTPUT: Return the count of numbers between the num1..num2 that are divisible by num1.

ERROR CASES: Return -1 in error cases.
*/

public class StepDivisor {
    protected int findStepDividends(int low, int high) {
        if (low == high || low > high) {
            return -1;
        }
        while (high % low != 0) {
            high = high - 1;
        }
        return (((high - low) / low) + 1);
    }
}
