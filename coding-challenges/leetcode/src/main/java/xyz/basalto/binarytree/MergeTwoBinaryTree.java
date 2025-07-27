package xyz.basalto.binarytree;

import java.util.Objects;

/**
 * This class provides a method to merge two binary trees.
 */
public class MergeTwoBinaryTree {

    /**
     * Merges two binary trees into a new binary tree.
     *
     * @param first the first binary tree
     * @param second the second binary tree
     * @return a new binary tree that is the result of merging the two input trees
     * @throws NullPointerException if either of the input trees is null
     * @throws IllegalArgumentException if either of the input trees has a null root
     */
    public BinaryTree mergeTrees(BinaryTree first, BinaryTree second){
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);
        if(first.root == null || second.root == null)
            throw new IllegalArgumentException("Either binary tree has a null root");
            
        BinaryTreeNode root = mergeNodes(first.root, second.root);
        return new BinaryTree(root);
    }

    /**
     * Helper method to merge two binary tree nodes.
     *
     * @param root1 the root node of the first binary tree
     * @param root2 the root node of the second binary tree
     * @return a new binary tree node that is the result of merging the two input nodes
     */
    private BinaryTreeNode mergeNodes(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        BinaryTreeNode merged = new BinaryTreeNode(root2.value + root1.value);
        merged.left = mergeNodes(root1.left, root2.left);
        merged.right = mergeNodes(root1.right, root2.right);
        return merged;
    }

}
