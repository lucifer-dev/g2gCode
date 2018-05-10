package com.coding;

class LinkedListIntAdder {
    private ListHelper listHelper = new ListHelper();
    int carry = 0;

    private ListNode listAdder(ListNode addendList, ListNode adderList) {
        ListNode resultList = new ListNode();
        ListNode resultListHead;
        resultListHead = resultList;
        addendList = listHelper.reverseList(addendList, true);
        adderList = listHelper.reverseList(adderList, true);
        assert adderList != null;
        assert addendList != null;
        if (addendList.sdata.contentEquals("+") && adderList.sdata.contentEquals("+")) {
            addLinkedListNumbers(addendList.nextNode, adderList.nextNode, resultList);
            resultListHead.sdata = "+";
        }

        if (addendList.sdata.contentEquals("-") && adderList.sdata.contentEquals("-")) {
            addLinkedListNumbers(addendList.nextNode, adderList.nextNode, resultList);
            resultListHead.sdata = "-";
        }

        if ((addendList.sdata.contentEquals("-") && adderList.sdata.contentEquals("+")) || (addendList.sdata
                .contentEquals("+") && adderList.sdata.contentEquals("-"))) {
            if (compareLinkedListIntegers(addendList, addendList) == 1) {
                subtractLinkedListNumbers(addendList.nextNode, adderList.nextNode, resultList);
                resultListHead.sdata = addendList.sdata;
            } else {
                subtractLinkedListNumbers(adderList.nextNode, addendList.nextNode, resultList);
                resultListHead.sdata = adderList.sdata;
            }
        }
        return resultListHead;
    }

    private  void addLinkedListNumbers(ListNode addendList, ListNode adderList, ListNode resultList) {
        int addCarry = 0;
        int sum;

        while (addendList != null && adderList != null && addendList.idata != null && adderList.idata != null) {
            sum = addendList.idata + adderList.idata + addCarry;
            if (sum > 10) {
                sum = sum - 10;
                addCarry = 1;
            } else {
                addCarry = 0;
            }
            resultList = addIntToList(sum, resultList);
            addendList = addendList.nextNode;
            adderList = adderList.nextNode;
        }
    }

    private  void subtractLinkedListNumbers(ListNode minuendList, ListNode subtrahendList, ListNode resultList) {
        int carryDiff = 0;
        int difference;

        while (minuendList != null && subtrahendList != null && minuendList.idata != null && subtrahendList.idata !=
                null) {
            if (minuendList.idata + carryDiff < subtrahendList.idata) {
                minuendList.idata = minuendList.idata + 11 + carryDiff;
                carryDiff = -1;
            } else if (minuendList.idata + carryDiff >= subtrahendList.idata) {
                minuendList.idata = minuendList.idata + carryDiff;
                carryDiff = 0;
            }
            difference = minuendList.idata - subtrahendList.idata;
            resultList = addIntToList(difference, resultList);
            minuendList = minuendList.nextNode;
            subtrahendList = subtrahendList.nextNode;
        }
    }

    private  ListNode addIntToList(int result, ListNode resultList) {
        resultList.nextNode = listHelper.createListFromNumber(result, false);
        while (resultList.nextNode != null && resultList.nextNode.idata != null) {
            resultList = resultList.nextNode;
        }
        return resultList;
    }

    private  int compareLinkedListIntegers(ListNode input1, ListNode input2) {
        int result = 0;
        ListNode temp1 = input1;
        ListNode temp2 = input2;
        while (temp1.nextNode != null && temp2.nextNode != null && temp1.idata != null && temp2.idata != null) {
            if (temp1.idata > temp2.idata) {
                result = 1;
            } else if (temp1.idata < temp2.idata) {
                result = -1;
            }
            temp1 = temp1.nextNode;
            temp2 = temp2.nextNode;
        }
        return result;
    }
}
