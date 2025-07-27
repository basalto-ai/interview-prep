package xyz.basalto.binarytree;

public class TiltBinaryTree {

    private int totalTilt = 0;

    public int tild(BinaryTree tree){
        tild(tree.root);
        return totalTilt;
    }

    private int tild(BinaryTreeNode node){
        if (node == null) return 0;

        int leftSum = tild(node.left);
        int rightSum = tild(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        return node.value + leftSum + rightSum;
    }

}
