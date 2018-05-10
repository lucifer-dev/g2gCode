/*
  @author moni
 */

package dev.coding;

public class Main {
    public static void main(String[] args) throws NullPointerException {
        int[] inputValues = {1, 5, 8, 10, 12, 20, 22, 25, 30, 36, 38, 40, 45, 48, 50};
        TreeUtils treeUtils = new TreeUtils();
        TreeNode root = treeUtils.createTreeFromList(inputValues);
        System.out.print("Original Tree : ");
        treeUtils.printTreeLevelOrder(root);
        treeUtils.connectNodesAtSameLevel(root);
        System.out.print("\nConnected Tree : ");
        treeUtils.printConnectedTree(root);
    }
}
