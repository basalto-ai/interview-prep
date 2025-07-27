package xyz.basalto.binarytree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

    private int diameter;

    public int diameterOfBinaryTree(BinaryTree binaryTree){
        height(binaryTree.root);
        return diameter;
    }

    private int height(BinaryTreeNode node){
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
