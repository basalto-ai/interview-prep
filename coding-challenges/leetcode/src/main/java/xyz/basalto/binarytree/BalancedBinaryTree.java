package xyz.basalto.binarytree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class BalancedBinaryTree {

    public boolean isBalanced(BinaryTree binaryTree) {
        return checkHeight(binaryTree.root) != -1;
    }

    private int checkHeight(BinaryTreeNode node) {
        // Base case: an empty node has height 0.
        if (node == null) {
            return 0;
        }
        
        int leftHeight = checkHeight(node.left);
        // If the left subtree is unbalanced, propagate -1.
        if (leftHeight == -1) {
            return -1;
        }
        
        int rightHeight = checkHeight(node.right);
        // If the right subtree is unbalanced, propagate -1.
        if (rightHeight == -1) {
            return -1;
        }
        
        // If the current node's subtrees differ in height by more than 1,
        // then this node is unbalanced.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        // Return the height of this subtree.
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
