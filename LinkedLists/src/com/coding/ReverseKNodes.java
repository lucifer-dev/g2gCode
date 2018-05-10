package com.coding;

public class ReverseKNodes {
    private final int stepSize;
    ListHelper listHelper = new ListHelper();

    public ReverseKNodes(int size) {
        stepSize = size;
    }

    private ListNode reverseKNodes(ListNode firstNode) {
        ListNode lastNode = null;
        ListNode nextNode = null;
        ListNode tempNode = firstNode;

        for (int currentStep = 1; (currentStep < stepSize && tempNode.nextNode != null); currentStep++) {
            tempNode = tempNode.nextNode;
        }
        lastNode = tempNode;
        nextNode = tempNode.nextNode;
        tempNode.nextNode = null;

        listHelper.reverseList(firstNode, true);

        if (nextNode == null) {
            firstNode.nextNode = null;
            return lastNode;
        }

        firstNode.nextNode = reverseKNodes(nextNode);
        return lastNode;
    }

    private ListNode reverseAlternateKNodes(ListNode firstNode, Boolean reverseFlag) {
        ListNode lastNode;
        ListNode nextNode;
        ListNode tempNode = firstNode;

        if(firstNode == null) {
            return null;
        }

        for (int currentStep = 1; (currentStep < stepSize && tempNode.nextNode != null); currentStep++) {
            tempNode = tempNode.nextNode;
        }

        lastNode = tempNode;
        nextNode = tempNode.nextNode;
        tempNode.nextNode = null;

        if (reverseFlag) {
            listHelper.reverseList(firstNode, reverseFlag);

            if (nextNode == null) {
                firstNode.nextNode = null;
                return lastNode;
            }
            firstNode.nextNode = reverseAlternateKNodes(nextNode, !reverseFlag);
            return lastNode;
        }

        lastNode.nextNode = reverseAlternateKNodes(nextNode, !reverseFlag);
        return firstNode;
    }
}
