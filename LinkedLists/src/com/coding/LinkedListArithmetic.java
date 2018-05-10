package com.coding;

/**
 * @author monisram
 */

public class LinkedListArithmetic {
    private ListHelper listHelper = new ListHelper();
    private ListNode resultList;
    private ListNode addendList, adderList, tempListHead, propogateListHead;
    private int additionCarry = 0;

    LinkedListArithmetic(ListNode inputListOne, ListNode inputListTwo, ListNode inputResultList) {
        this.resultList = inputResultList;
        this.addendList = inputListOne;
        this.adderList = inputListTwo;
    }

    public ListNode addLinkedListNumbersRecursion() {
        int addendListSize = listHelper.getLinkedListSize(addendList);
        int adderListSize = listHelper.getLinkedListSize(adderList);
        int listSizeDiff = Math.abs(addendListSize - adderListSize);
        if (addendListSize > adderListSize) {
            propogateListHead = addendList;
            while (listSizeDiff > 0) {
                addendList = addendList.nextNode;
                listSizeDiff = listSizeDiff - 1;
            }
            tempListHead = addendList;
        } else if (addendListSize < adderListSize) {
            propogateListHead = adderList;
            while (listSizeDiff > 0) {
                adderList = adderList.nextNode;
                listSizeDiff = listSizeDiff - 1;
            }
            tempListHead = adderList;
        }
        addListsOfSameSize(addendList, adderList);
        propagateCarry(propogateListHead);
        return resultList;
    }

    private void propagateCarry(ListNode listHead) {
        int sum;
        ListNode newNode;
        if (listHead == null || listHead == tempListHead) {
            return;
        }
        propagateCarry(listHead.nextNode);
        newNode = new ListNode();
        sum = listHead.idata + additionCarry;
        if (sum >= 10) {
            sum = sum - 10;
            additionCarry = 1;
        } else {
            additionCarry = 0;
        }
        newNode.idata = sum;
        if (resultList == null) {
            resultList = newNode;
        } else {
            newNode.nextNode = resultList;
            resultList = newNode;
        }

    }

    private void addListsOfSameSize(ListNode addendList, ListNode adderList) {
        int sum;
        if (addendList == null && adderList == null) {
            return;
        }
        addListsOfSameSize(addendList.nextNode, adderList.nextNode);
        ListNode newNode = new ListNode();
        sum = addendList.idata + adderList.idata + additionCarry;
        if (sum >= 10) {
            sum = sum - 10;
            additionCarry = 1;
        } else {
            additionCarry = 0;
        }
        newNode.idata = sum;
        if (resultList == null) {
            resultList = newNode;
        } else {
            newNode.nextNode = resultList;
            resultList = newNode;
        }
    }
}
