/*
  @author moni
 */

package dev.coding;

import java.util.*;

class TreeUtils {
    TreeNode createTreeFromList(int[] inputList) {
        ArrayList<Integer> inputArray = new ArrayList<>();
        for (int inputValue : inputList) {
            inputArray.add(inputValue);
        }
        return createTreeFromArray(inputArray, 0, inputList.length);
    }

    private TreeNode createTreeFromArray(ArrayList<Integer> inputArray, int start, int end) {
        if ((start > end) || (start == end))
            return null;

        int mid = (start + end) / 2;

        TreeNode node = new TreeNode();
        node.iData = inputArray.get(mid);
        node.leftChild = createTreeFromArray(inputArray, start, mid);
        if (node.leftChild != null && node.leftChild.iData == node.iData) {
            node.leftChild = null;
        }
        node.rightChild = createTreeFromArray(inputArray, mid + 1, end);
        if (node.rightChild != null && node.rightChild.iData == node.iData) {
            node.rightChild = null;
        }
        return node;
    }

    void printTreeLevelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            root = nodeQueue.remove();
            System.out.print(root.iData + " ");
            if (root.leftChild != null) {
                nodeQueue.add(root.leftChild);
            }
            if (root.rightChild != null) {
                nodeQueue.add(root.rightChild);
            }
        }
    }

    private void printTreeInorder(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        while (root != null) {
            nodeStack.push(root);
            root = root.leftChild;
        }
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            System.out.print(root.iData + " ");
            if (root.rightChild != null) {
                root = root.rightChild;
                while (root != null) {
                    nodeStack.push(root);
                    root = root.leftChild;
                }
            }
        }
    }

    private void printTreePreorder(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            System.out.print(root.iData + " ");
            if (root.leftChild != null) {
                nodeStack.push(root.rightChild);
            }
            if (root.rightChild != null) {
                nodeStack.push(root.leftChild);
            }
        }
    }

    private void printTreeReverseLevelOrder(TreeNode root) {
        /*
            https://www.geeksforgeeks.org/reverse-level-order-traversal/
         */
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            root = nodeQueue.remove();
            nodeStack.push(root);
            if (root.leftChild != null) {
                nodeQueue.add(root.rightChild);
            }
            if (root.rightChild != null) {
                nodeQueue.add(root.leftChild);
            }
        }
        while (!nodeStack.isEmpty()) {
            System.out.print(nodeStack.pop().iData + " ");
        }
    }

    private void printTreeSpiralOrder(TreeNode root) {
        /*
           https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
        */
        Stack<TreeNode> nodeStackOne = new Stack<>();
        Stack<TreeNode> nodeStackTwo = new Stack<>();

        nodeStackOne.push(root);
        while (!nodeStackOne.isEmpty() || !nodeStackTwo.isEmpty()) {
            while (!nodeStackOne.isEmpty()) {
                root = nodeStackOne.pop();
                System.out.print(root.iData + " ");
                if (root.rightChild != null) {
                    nodeStackTwo.push(root.rightChild);
                }
                if (root.leftChild != null) {
                    nodeStackTwo.push(root.leftChild);
                }
            }
            while (!nodeStackTwo.isEmpty()) {
                root = nodeStackTwo.pop();
                System.out.print(root.iData + " ");
                if (root.rightChild != null) {
                    nodeStackOne.push(root.leftChild);
                }
                if (root.leftChild != null) {
                    nodeStackOne.push(root.rightChild);
                }
            }
        }
    }

    private void printTreeBoundaryNodes(TreeNode root) {
        /*
            https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
        */
        // Print Left boundary
        printLeftSkewTree(root);
        // Print right boundary
        printTreeLeaves(root);
        // Print central boundary
        printRightSkewTree(root);
    }

    private void printSpecificLevelOrderTopToBottom(TreeNode root) {
        /*
            https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/
         */
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root.leftChild);
        nodeQueue.add(root.rightChild);
        System.out.print(root.iData + " ");
        while (!nodeQueue.isEmpty()) {
            TreeNode nodeOne = nodeQueue.remove();
            TreeNode nodeTwo = nodeQueue.remove();
            System.out.print(nodeOne.iData + " ");
            System.out.print(nodeTwo.iData + " ");
            if (nodeOne.leftChild != null) {
                nodeQueue.add(nodeOne.leftChild);
            }
            if (nodeTwo.rightChild != null) {
                nodeQueue.add(nodeTwo.rightChild);
            }
            if (nodeOne.rightChild != null) {
                nodeQueue.add(nodeOne.rightChild);
            }
            if (nodeTwo.leftChild != null) {
                nodeQueue.add(nodeTwo.leftChild);
            }
        }
    }

    private void printSpecificLevelOrderBottomToTop(TreeNode root) {
        /*
            https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal-set-2/
         */
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeQueue.add(root.leftChild);
        nodeQueue.add(root.rightChild);
        nodeStack.push(root);
        nodeStack.push(root.rightChild);
        nodeStack.push(root.leftChild);
        while (!nodeQueue.isEmpty()) {
            TreeNode nodeOne = nodeQueue.remove();
            TreeNode nodeTwo = nodeQueue.remove();
            if (nodeOne.leftChild != null && nodeTwo.rightChild != null &&
                    nodeOne.rightChild != null && nodeTwo.leftChild != null) {
                nodeQueue.add(nodeOne.rightChild);
                nodeQueue.add(nodeTwo.leftChild);
                nodeQueue.add(nodeOne.leftChild);
                nodeQueue.add(nodeTwo.rightChild);

                // Add elements to stack to print.
                nodeStack.push(nodeTwo.leftChild);
                nodeStack.push(nodeOne.rightChild);
                nodeStack.push(nodeTwo.rightChild);
                nodeStack.push(nodeOne.leftChild);
            }
        }
        while (!nodeStack.isEmpty()) {
            System.out.print(nodeStack.pop().iData + " ");
        }

    }

    private void linkedListToTree(LinkedList inputList, TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Iterator linkedListIterator = inputList.iterator();
        root.iData = Integer.parseInt(linkedListIterator.next().toString());
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty() && linkedListIterator.hasNext()) {
            root = nodeQueue.remove();
            /* Add left child to the current element */
            root.leftChild = new TreeNode();
            root.leftChild.iData = Integer.parseInt(linkedListIterator.next().toString());
            nodeQueue.add(root.leftChild);
            /* Add right child to the current element */
            root.rightChild = new TreeNode();
            root.rightChild.iData = Integer.parseInt(linkedListIterator.next().toString());
            nodeQueue.add(root.rightChild);
        }
    }

    private TreeNode mirrorTree(TreeNode root) {
        /*
            https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
         */
        TreeNode temp;
        temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
        if (root.leftChild != null) {
            mirrorTree(root.leftChild);
        }
        if (root.rightChild != null) {
            mirrorTree(root.rightChild);
        }
        return root;
    }

    private TreeNode constructSpecialTree(ArrayList<Integer> preOrder, ArrayList<Character> nodeType) {
        /*
            https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
         */
        int value = preOrder.get(0);
        char type = nodeType.get(0);
        TreeNode root = new TreeNode();
        root.iData = value;

        preOrder.remove(0);
        nodeType.remove(0);

        if (preOrder.isEmpty() || type == 'L') {
            return root;
        }
        root.leftChild = constructSpecialTree(preOrder, nodeType);
        root.rightChild = constructSpecialTree(preOrder, nodeType);
        return root;
    }

    private int distanceBetweenNodesInBinaryTree(TreeNode root, int keyOne, int keyTwo) {
        /*
            https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
         */
        int pathOneIndex, pathTwoIndex;
        int lcaDistanceFromRoot = 0;
        ArrayList<TreeNode> keyOnePath = new ArrayList<>();
        ArrayList<TreeNode> keyTwoPath = new ArrayList<>();

        findPathToNode(root, keyOne, keyOnePath);
        findPathToNode(root, keyTwo, keyTwoPath);
        pathOneIndex = keyOnePath.size() - 1;
        pathTwoIndex = keyTwoPath.size() - 1;

        while (pathOneIndex >= 0 && pathTwoIndex >= 0) {
            if (keyOnePath.get(pathOneIndex).iData != keyTwoPath.get(pathTwoIndex).iData) {
                lcaDistanceFromRoot = lcaDistanceFromRoot - 1;
                break;
            }
            pathOneIndex = pathOneIndex - 1;
            pathTwoIndex = pathTwoIndex - 1;
            lcaDistanceFromRoot = lcaDistanceFromRoot + 1;
        }

        if (lcaDistanceFromRoot == keyOnePath.size() || lcaDistanceFromRoot == keyTwoPath.size()) {
            lcaDistanceFromRoot = lcaDistanceFromRoot - 1;
        }

        return ((keyOnePath.size() + keyTwoPath.size()) - (2 * (lcaDistanceFromRoot + 1)));
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int keyOne, int keyTwo) {
        /*
            https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
         */
        if (root == null) return null;
        if (root.iData == keyOne || root.iData == keyTwo) {
            return root;
        }
        TreeNode leftSubTreeLCA = lowestCommonAncestor(root.leftChild, keyOne, keyTwo);
        TreeNode rightSubTreeLCA = lowestCommonAncestor(root.rightChild, keyOne, keyTwo);
        if (leftSubTreeLCA != null && rightSubTreeLCA != null) {
            return root;
        }
        return (leftSubTreeLCA != null) ? leftSubTreeLCA : rightSubTreeLCA;
    }

    private boolean findPathToNode(TreeNode root, int node, ArrayList<TreeNode> path) {
        boolean pathFound = false;
        if (root == null) {
            return false;
        }

        if (root.iData == node) {
            path.add(root);
            return true;
        }

        if (findPathToNode(root.leftChild, node, path) ||
                findPathToNode(root.rightChild, node, path)) {
            path.add(root);
            pathFound = true;
        }
        return pathFound;
    }

    private void printLeftSkewTree(TreeNode root) {
        while (root != null) {
            if (!(root.leftChild == null & root.rightChild == null)) {
                System.out.print(root.iData + " ");
            }
            root = root.leftChild;
        }
    }

    private TreeNode printRightSkewTree(TreeNode root) {
        if (root != null) {
            if (root.rightChild != null) {
                TreeNode childRoot = printRightSkewTree(root.rightChild);
                if (!(childRoot.leftChild == null && childRoot.rightChild == null)) {
                    System.out.print(childRoot.iData + " ");
                }
            }
            if (root.rightChild == null) {
                return root;
            }
        }
        return root;
    }

    private void printTreeLeaves(TreeNode root) {
        if (root.rightChild == null && root.leftChild == null) {
            System.out.print(root.iData + " ");
        }
        if (root.leftChild != null) {
            printTreeLeaves(root.leftChild);
        }
        if (root.rightChild != null) {
            printTreeLeaves(root.rightChild);
        }
    }

    void connectNodesAtSameLevel(TreeNode root) {
        TreeNode head = null;
        TreeNode next = null;
        /*
            https://www.geeksforgeeks.org/connect-nodes-at-same-level/
         */
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        ArrayList<TreeNode> connectList = new ArrayList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            while (!nodeQueue.isEmpty()) {
                root = nodeQueue.remove();
                connectList.add(root);
            }
            for (TreeNode node : connectList) {
                if (head == null) {
                    head = node;
                } else {
                    next = node;
                    head.nextRight = next;
                    head = next;
                }
                if (head.leftChild != null) {
                    nodeQueue.add(head.leftChild);
                }
                if (head.rightChild != null) {
                    nodeQueue.add(head.rightChild);
                }
            }
            head = null;
            connectList.clear();
        }
    }

    void printConnectedTree(TreeNode root) {
        /* https://www.geeksforgeeks.org/connect-nodes-at-same-level/ */
        if (root.leftChild != null) {
            printConnectedTree(root.leftChild);
        }
        System.out.print(root.iData + "-->");
        if (root.nextRight != null) {
            TreeNode temp = root.nextRight;
            while (temp.nextRight != null) {
                System.out.print(temp.iData + "-->");
                temp = temp.nextRight;
            }
            System.out.print(temp.iData);
        }
        System.out.print("\n");
    }

    private static Boolean checkIfBST(TreeNode root) {
        /**
         * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
         */
        Boolean isBst = true;
        if (root == null) {
            return false;
        }
        if (root.leftChild != null) {
            if (!checkIfBST(root.leftChild)) {
                return false;
            }
            if (!(root.leftChild.iData < root.iData)) {
                isBst = false;
            }
        }
        if (root.rightChild != null) {
            if (!checkIfBST(root.rightChild)) {
                return false;
            }
            if (!(root.rightChild.iData > root.iData)) {
                isBst = false;
            }
        }
        return isBst;
    }

    int convertBinaryTreeToSumTree(TreeNode root) {
        /*
         * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
         */
        int rootSum = 0;
        if (root == null) {
            return 0;
        }
        if (root.leftChild != null) {
            rootSum = rootSum + root.leftChild.iData;
        }
        if (root.rightChild != null) {
            rootSum = rootSum + root.rightChild.iData;
        }
        rootSum = rootSum + convertBinaryTreeToSumTree(root.leftChild) + convertBinaryTreeToSumTree(root.rightChild);
        if (rootSum == 0) {
            root.iData = 0;
        } else {
            root.iData += rootSum;
        }
        return rootSum;
    }
}
