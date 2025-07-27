package xyz.basalto.interprep.basic.binarytree;

import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalIterative {

    /**
     * Performs level-order (breadth-first) traversal of a binary tree and returns a list of values by level.
     * Each inner list contains the values at one level of the tree.
     *
     * @param binaryTree The binary tree to traverse.
     * @param <T>        The type of node values.
     * @return A list of lists, where each inner list contains the values of a level in the tree.
     */
    public static <T> List<List<T>> traverse(BinaryTree<T> binaryTree) {
        List<List<T>> result = new ArrayList<>();

        if (binaryTree.getRoot() == null) {
            return result;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(binaryTree.getRoot());

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<T> level = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                BinaryTreeNode<T> node = queue.poll();
                level.add(node.getValue());

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }

            result.add(level);
        }

        return result;
    }
}
