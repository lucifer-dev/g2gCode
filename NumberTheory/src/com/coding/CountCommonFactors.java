package com.coding;

/*
*
Problem - To find the number of factorials in a given range.

Description - You will be given an input array[l, h] which gives the range.Your job is to return the count of the number of factorials between 'l' and 'h' both included.

Example: input = [2, 10]
		 The factorials between 2 and 10 is '2' alone. Hence 1 must be returned.


Constraints :
1) The range should not be negative, i.e neither of l and h should be negative.If so, return -1.
2) l, h are both long integers.
3) The range should be non decreasing, i.e l <= h.It is not, return -1
*/

public class CountCommonFactors {

    protected int countCommonFactors(int low, int high) {
        int countOfCommonFactors = 0, iterLoop;
        if (low >= high || low <= 0 || high <= 0) {
            return -1;
        }

        for (iterLoop = 2; iterLoop <= Math.ceil(low / 2) + 1; iterLoop++) {
            if (low % iterLoop == 0) {
                if (high % iterLoop == 0) {
                    System.out.print(iterLoop + ",");
                    countOfCommonFactors = countOfCommonFactors + 1;
                }
            }
        }
        return countOfCommonFactors;
    }
}
