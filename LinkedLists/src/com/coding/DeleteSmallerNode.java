package com.coding;

class DeleteSmallerNode {
    ListHelper listHelper = new ListHelper();

    public DeleteSmallerNode(ListNode headNode) {
        int max;
        boolean isHead = true;
        ListNode tempNode, currentNode;

        if (headNode == null) {
            listHelper.printList(null);
            return;
        }

        headNode = listHelper.reverseList(headNode, true);
        currentNode = headNode;
        max = headNode.idata;
        while (currentNode.nextNode != null) {
            if (max > currentNode.nextNode.idata) {
                tempNode = currentNode.nextNode;
                currentNode.nextNode = tempNode.nextNode;
                tempNode.nextNode = null;
            } else if (currentNode.idata < currentNode.nextNode.idata) {
                max = currentNode.nextNode.idata;
                if (isHead) {
                    headNode = currentNode;
                    isHead = !isHead;
                }
                currentNode = currentNode.nextNode;
            }
        }
        headNode = listHelper.reverseList(headNode, true);
        listHelper.printList(headNode);
    }
}
