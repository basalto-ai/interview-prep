package xyz.basalto.binarytree;

public class InvertBinaryTree {

    public void invert(BinaryTree binaryTree){
        invertNode(binaryTree.root);
    }

    public BinaryTreeNode invertNode(BinaryTreeNode node){
        if (node == null) return node;

        BinaryTreeNode invertedLeft = invertNode(node.left);
        BinaryTreeNode invertedRight = invertNode(node.right);

        // swap
        node.left = invertedRight;
        node.right = invertedLeft;

        return node;
    }

}
