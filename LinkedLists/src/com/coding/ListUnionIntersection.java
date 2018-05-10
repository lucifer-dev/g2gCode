/*
 * @author moni
 */
package com.coding;

class ListUnionIntersection {
    ListHelper listHelper;
    private  ListNode linkedListUnion(ListNode listHeadOne, ListNode listHeadTwo) {
        ListNode sortedList = listHelper.sortLinkedList(listHelper.appendLinkedList(listHeadOne, listHeadTwo));
        ListNode temp = sortedList;
        do if (sortedList.idata.equals(sortedList.nextNode.idata)) {
            sortedList.nextNode = sortedList.nextNode.nextNode;
        } else {
            sortedList = sortedList.nextNode;
        } while(sortedList.nextNode != null);
        return temp;
    }

    private  ListNode linkedListIntersection(ListNode listHeadOne, ListNode listHeadTwo) {
        ListNode interSectionListHead = new ListNode();
        ListNode interSectionList = interSectionListHead;
        listHeadOne = listHelper.sortLinkedList(listHeadOne);
        listHeadTwo = listHelper.sortLinkedList(listHeadTwo);

        while(listHeadOne != null && listHeadTwo != null) {
            if(listHeadOne.idata.equals(listHeadTwo.idata)) {
                interSectionList.nextNode = listHeadOne;
                interSectionList = interSectionList.nextNode;
                listHeadOne = moveTillDifferentValue(listHeadOne);
                listHeadTwo = moveTillDifferentValue(listHeadTwo);
                listHeadOne = listHeadOne.nextNode;
                listHeadTwo = listHeadTwo.nextNode;
                interSectionList.nextNode = null;
            }
            else if(listHeadOne.idata > listHeadTwo.idata) {
                listHeadTwo = listHeadTwo.nextNode;
            } else listHeadOne = listHeadOne.nextNode;
        }
        return interSectionListHead.nextNode;
    }

    private ListNode moveTillDifferentValue(ListNode head){
        while(head!=null && head.nextNode!=null && head.idata.equals(head.nextNode.idata)) {
            head = head.nextNode;
        }
        return head;
    }
}
