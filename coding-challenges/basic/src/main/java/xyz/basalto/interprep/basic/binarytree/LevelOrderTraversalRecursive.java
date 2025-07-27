package xyz.basalto.interprep.basic.binarytree;

import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalRecursive {


    /**
     * Performs in-order traversal of a binary tree and returns a list of values.
     */
    public static <T> List<List<T>> traverse(BinaryTree<T> binaryTree) {
        List<List<T>> result = new ArrayList<>();
        levelOrderTraverse(binaryTree.getRoot(), 0, result);
        return result;
    }

    private static <T> void levelOrderTraverse(BinaryTreeNode<T> node, int level, List<List<T>> result) {
        if (node == null) return;

        if(result.size() <= level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.getValue());

        levelOrderTraverse(node.getLeft(), level + 1, result);
        levelOrderTraverse(node.getRight(), level + 1, result);
    }

}
