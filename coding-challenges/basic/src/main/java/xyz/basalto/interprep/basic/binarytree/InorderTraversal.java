package xyz.basalto.interprep.basic.binarytree;

import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    /**
     * Performs in-order traversal of a binary tree and returns a list of values.
     */
    public static <T> List<T> traverse(BinaryTree<T> binaryTree) {
        List<T> result = new ArrayList<>();
        inOrder(binaryTree.getRoot(), result);
        return result;
    }

    private static <T> void inOrder(BinaryTreeNode<T> node, List<T> result) {
        if (node == null) return;

        inOrder(node.getLeft(), result);
        result.add(node.getValue());
        inOrder(node.getRight(), result);
    }

}
