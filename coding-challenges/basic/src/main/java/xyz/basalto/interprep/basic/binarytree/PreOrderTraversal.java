package xyz.basalto.interprep.basic.binarytree;

import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

    /**
     * Performs in-order traversal of a binary tree and returns a list of values.
     */
    public static <T> List<T> traverse(BinaryTree<T> binaryTree) {
        List<T> result = new ArrayList<>();
        preOrder(binaryTree.getRoot(), result);
        return result;
    }

    private static <T> void preOrder(BinaryTreeNode<T> root, List<T> result) {
        if (root == null) return;
        result.add(root.getValue());
        preOrder(root.getLeft(), result);
        preOrder(root.getRight(), result);
    }

}
