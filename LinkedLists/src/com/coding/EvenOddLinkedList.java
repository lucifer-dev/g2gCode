package com.coding;

public class EvenOddLinkedList {
    ListHelper listHelper = new ListHelper();
    public EvenOddLinkedList(ListNode inputList) {
        ListNode evenNodesHead = new ListNode();
        ListNode oddNodesHead = new ListNode();
        ListNode evenNodes = evenNodesHead;
        ListNode oddNodes = oddNodesHead;

        while (inputList != null) {
            if (inputList.idata == 0 || inputList.idata % 2 == 0) {
                evenNodes.nextNode = inputList;
                inputList = inputList.nextNode;
                evenNodes = evenNodes.nextNode;
                evenNodes.nextNode = null;
            } else {
                oddNodes.nextNode = inputList;
                inputList = inputList.nextNode;
                oddNodes = oddNodes.nextNode;
                oddNodes.nextNode = null;
            }
        }
        evenNodesHead = evenNodesHead.nextNode;
        oddNodesHead = oddNodesHead.nextNode;
        evenNodes.nextNode = oddNodesHead;
        System.out.print("\n After : ");
        listHelper.printList(evenNodesHead);
    }
}
