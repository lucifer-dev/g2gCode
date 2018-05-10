/*
  @author moni
 */

package com.coding;

import java.util.ArrayList;

class ListHelper {

    public ListNode createListFromArray(ArrayList<Integer> inputArray) {
        ListNode head = null;
        ListNode lastNode = null;
        ListNode nextNode;
        for (int input : inputArray) {
            if (head == null) {
                head = new ListNode();
                nextNode = head;
                head.nextNode = null;
                lastNode = head;
            } else {
                ListNode newNode = new ListNode();
                nextNode = newNode;
                lastNode.nextNode = newNode;
                lastNode = newNode;
            }
            nextNode.idata = input;
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.idata == null) {
                System.out.print(temp.sdata + " ->");
            } else {
                System.out.print(temp.idata + "->");
            }
            temp = temp.nextNode;
        }
    }

    public ListNode reverseList(ListNode inputList, Boolean reverseFlag) {
        ListNode previousNode;
        ListNode currentNode;
        ListNode nextNode;

        if (!reverseFlag) {
            return null;
        }

        if (inputList == null) {
            return null;
        } else if (inputList.nextNode == null) {
            return inputList;
        } else if (inputList.nextNode.nextNode == null) {
            ListNode tempNode = inputList.nextNode;
            tempNode.nextNode = inputList;
            inputList.nextNode = null;
            return tempNode;
        }

        previousNode = inputList;
        currentNode = inputList.nextNode;
        nextNode = currentNode.nextNode;

        while (nextNode != null) {
            currentNode.nextNode = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.nextNode;
        }
        currentNode.nextNode = previousNode;
        inputList.nextNode = null;
        return currentNode;
    }

    public ListNode createListFromNumber(int input, Boolean includeSign) {
        Boolean isNumberNegative = false;
        ListNode outputListHead = new ListNode();
        ListNode outputList = outputListHead;
        if (input < 0) {
            isNumberNegative = true;
            input = -input;
        }
        while (input > 0) {
            ListNode newIntNode = new ListNode();
            newIntNode.idata = input % 10;
            outputList.nextNode = newIntNode;
            outputList = outputList.nextNode;
            input = input / 10;
        }
        if (includeSign) {
            ListNode signNode = new ListNode();
            outputList.nextNode = signNode;
            if (isNumberNegative) {
                signNode.sdata = "-";
            } else {
                signNode.sdata = "+";
            }
        }
        outputListHead = outputListHead.nextNode;
        return reverseList(outputListHead, true);
    }

    public ListNode createLinkedListLoop(ListNode head, int loopNodeIndex) {
        ListNode temp = head;
        ListNode loopNode = head;

        if (head.nextNode == null) {
            head.nextNode = head;
            return  head;
        } else if (head == null) {
            return head;
        }
        while (head.nextNode != null) {
            head = head.nextNode;
        }
        while (loopNodeIndex > 1 && loopNode.nextNode != null) {
            loopNode = loopNode.nextNode;
            loopNodeIndex = loopNodeIndex - 1;
        }
        head.nextNode = loopNode;
        return temp;
    }

    public ListNode sortLinkedList(ListNode head){
        if(head == null || head.nextNode == null) {
            return head;
        }
        ListNode middleNode = getListMiddleNode(head);
        ListNode nextToMiddleNode = middleNode.nextNode;

        middleNode.nextNode = null;

        ListNode listLeftHalf = sortLinkedList(head);
        ListNode listRightHalf = sortLinkedList(nextToMiddleNode);

        return sortedMerge(listLeftHalf, listRightHalf);
    }

    public ListNode sortedMerge(ListNode listOne, ListNode listTwo) {
        ListNode resultList;
        if (listOne == null) return listTwo;
        if (listTwo == null) return listOne;

        if (listOne.idata <= listTwo.idata)
        {
            resultList = listOne;
            resultList.nextNode = sortedMerge(listOne.nextNode, listTwo);
        }
        else
        {
            resultList = listTwo;
            resultList.nextNode = sortedMerge(listOne, listTwo.nextNode);
        }
        return resultList;

    }

    public ListNode getListMiddleNode(ListNode head){
        if(head == null) return null;

        ListNode fastpointer = head.nextNode;
        ListNode slowpointer = head;

        while (fastpointer != null)
        {
            fastpointer = fastpointer.nextNode;
            if(fastpointer!=null)
            {
                slowpointer = slowpointer.nextNode;
                fastpointer=fastpointer.nextNode;
            }
        }
        return slowpointer;
    }

    ListNode appendLinkedList(ListNode listOne, ListNode listTwo) {
        ListNode temp = listOne;
        while(temp.nextNode!=null){ temp = temp.nextNode;}
        temp.nextNode = listTwo;
        return listOne;
    }

    int getLinkedListSize(ListNode linkedList) {
        int listSize = 0;
        while (linkedList != null) {
            linkedList = linkedList.nextNode;
            listSize++;
        }
        return listSize++;
    }
}
