package com.coding;

import java.util.Stack;

/**
 * @author monisram
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 */

public class FindCelebrity {
    int peopleCount = 4;
    Stack<Integer> people = new Stack<Integer>();
    final Boolean acquaintance[][] = {
            {true, true, false, false},
            {true, true, false, true},
            {true, true, true, false},
            {true, true, true, true}
    };

    FindCelebrity() {
        for (int personId = 0; personId < peopleCount; personId++) {
            people.push(personId);
        }
    }

    private Boolean knows(int personA, int personB) {
        return acquaintance[personA][personB];
    }

    public int findTheCelebrity() {
        int currentPerson, nextPerson;
        currentPerson = people.pop();
        while (!people.isEmpty()) {
            nextPerson = people.pop();
            if (knows(currentPerson, nextPerson)) {
                currentPerson = nextPerson;
            }
        }

        for (int personId = 0; personId < peopleCount; personId++) {
            if (personId != currentPerson) {
                if (knows(currentPerson, personId)) {
                    return -1;
                }
            }
        }
        return currentPerson;
    }
}
