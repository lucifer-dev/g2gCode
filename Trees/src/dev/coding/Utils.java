/*
  @author moni
 */

package dev.coding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

class Utils {

    static ArrayList<Integer> createRandomIntegerArray(int size) {
        ArrayList<Integer> inputArray = new ArrayList<>();
        Random random = new Random();
        while (size > 0) {
            inputArray.add(random.nextInt(100));
            size = size - 1;
        }
        for (int input : inputArray) {
            System.out.print(input + " ");
        }
        System.out.print("\n");
        return inputArray;
    }

    static ArrayList<Integer> createIntegerArray(int size) {
        int element = 1;
        ArrayList<Integer> inputArray = new ArrayList<>();
        while (element <= size) {
            inputArray.add(element);
            element = element + 1;
        }

        for (int input : inputArray) {
            System.out.print(input + " ");
        }
        System.out.print("\n");
        return inputArray;
    }

    static LinkedList<Integer> createIntegerLinkedList(int size) {
        LinkedList<Integer> inputList = new LinkedList<>();
        for (int elementValue = 1; elementValue <= size; elementValue++) {
            inputList.add(elementValue);
        }
        Iterator listIterator = inputList.iterator();
        System.out.print("Linked List : ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.print("\n");
        return inputList;
    }
}
