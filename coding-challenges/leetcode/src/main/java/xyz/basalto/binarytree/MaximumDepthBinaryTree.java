package xyz.basalto.binarytree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthBinaryTree {

    public int maxDepth(BinaryTree binaryTree) {
        return maxDepth(binaryTree.root);
    }

    private int maxDepth(BinaryTreeNode node) {
        if (node == null){
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
