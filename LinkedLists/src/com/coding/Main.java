/*
  @author moni
 */

package com.coding;

import java.util.ArrayList;
import java.util.Random;

class Main {
    static ListHelper listHelper = new ListHelper();
    static LinkedListArithmetic linkedlListArithmetic;

    public static void main(String[] args) {
        ListNode inputListOne = listHelper.createListFromArray(IntegerStringToArray("12346913491234691349"));
        ListNode inputListTwo = listHelper.createListFromArray(IntegerStringToArray("1234691349"));
        ListNode resultList = null;
        linkedlListArithmetic = new LinkedListArithmetic(inputListOne, inputListTwo, resultList);

        System.out.print("\nList one : ");
        listHelper.printList(inputListOne);

        System.out.print("\nList two : ");
        listHelper.printList(inputListTwo);

        System.out.print("\nFinal List : ");
        listHelper.printList(linkedlListArithmetic.addLinkedListNumbersRecursion());
    }

    private static ArrayList<Integer> createArray(int size) {
        ArrayList<Integer> inputArray = new ArrayList<>();
        for (int loop = 1; loop <= size; loop++) {
            inputArray.add(loop);
        }
        return inputArray;
    }

    private static ArrayList<Integer> createArray(int[] inputs) {
        ArrayList<Integer> inputArray = new ArrayList<>();
        for (int input : inputs) {
            inputArray.add(input);
        }
        return inputArray;
    }

    private static ArrayList<Integer> createRandomElementArray(int size) {
        ArrayList<Integer> inputArray = new ArrayList<>();
        Random random = new Random();
        while (size > 0) {
            inputArray.add(random.nextInt(100));
            size = size - 1;
        }
        return inputArray;
    }

    private static ArrayList<Integer> IntegerStringToArray(String input) {
        ArrayList<Integer> outputArray = new ArrayList<>();
        for (int index = 0; index < input.length(); index++) {
            outputArray.add(Character.getNumericValue(input.charAt(index)));
        }
        return outputArray;
    }
}
