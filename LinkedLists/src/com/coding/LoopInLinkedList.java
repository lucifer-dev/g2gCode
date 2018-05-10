package com.coding;


class LoopInLinkedList {
    static void detectAndRemoveLoopInLinkedList(ListNode head) {
        int nodesInLoop = 1;
        ListNode fastPointer;
        fastPointer = checkLoopInLinkedList(head);
        ListNode slowPointer = fastPointer;
        if (fastPointer == null) return;
        while(fastPointer.nextNode!=slowPointer) {
            fastPointer = fastPointer.nextNode;
            nodesInLoop++;
        }
        slowPointer = head;
        fastPointer = head;
        while(nodesInLoop > 0) {
            fastPointer = fastPointer.nextNode;
            nodesInLoop--;
        }
        while(slowPointer.nextNode != fastPointer.nextNode) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode;
        }
        fastPointer.nextNode = null;
    }

    private static ListNode checkLoopInLinkedList(ListNode head) {
        ListNode slowPointer, fastPointer;
        if (head.nextNode != null && head.nextNode.nextNode != null) {
            slowPointer = head;
            fastPointer = head.nextNode.nextNode;
        } else {
            return null;
        }

        while (fastPointer.nextNode != null && fastPointer.nextNode.nextNode != null
                && slowPointer!= fastPointer) {
            slowPointer = slowPointer.nextNode;
            fastPointer = fastPointer.nextNode.nextNode;
        }
        if (fastPointer == slowPointer) {
            return fastPointer;
        }
        return null;
    }
}
