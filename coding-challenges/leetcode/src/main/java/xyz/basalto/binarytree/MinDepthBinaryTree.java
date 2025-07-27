package xyz.basalto.binarytree;

public class MinDepthBinaryTree {

    public int minDepth(BinaryTree binaryTree){
        return minDepth(binaryTree.root);
    }   

    private int minDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null) {
            return 1 + minDepth(node.right);
        }

        if (node.right == null) {
            return 1 + minDepth(node.left);
        }

        // If both subtrees exist, return the minimum depth between them + 1
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

}
