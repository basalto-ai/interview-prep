package xyz.basalto.interprep.basic.binarytree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LevelOrderTraversalIterative Tests")
class LevelOrderTraversalIterativeTest {

    /**
     * Helper to wrap a root node in a binary tree and run the traversal.
     */
    private List<List<Integer>> traverseTreeWithRoot(BinaryTreeNode<Integer> root) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(root);
        return LevelOrderTraversalIterative.traverse(tree);
    }

    /**
     * Tree: null
     */
    @Test
    @DisplayName("Test with an empty tree")
    void traverse_withEmptyTree_shouldReturnEmptyList() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<List<Integer>> result = LevelOrderTraversalIterative.traverse(tree);
        assertTrue(result.isEmpty());
    }

    /**
     * Tree:
     *     42
     * Expected: [[42]]
     */
    @Test
    @DisplayName("Test with a single-node tree")
    void traverse_withSingleNodeTree_shouldReturnSingleLevel() {
        List<List<Integer>> result = traverseTreeWithRoot(new BinaryTreeNode<>(42));
        assertEquals(List.of(List.of(42)), result);
    }

    /**
     * Tree:
     *       2
     *      / \
     *     1   3
     * Expected: [[2], [1, 3]]
     */
    @Test
    @DisplayName("Test with a balanced tree")
    void traverse_withBalancedTree_shouldReturnLevelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2,
                new BinaryTreeNode<>(1),
                new BinaryTreeNode<>(3));
        List<List<Integer>> result = traverseTreeWithRoot(root);
        assertEquals(List.of(List.of(2), List.of(1, 3)), result);
    }

    /**
     * Tree:
     *       4
     *      /
     *     3
     *    /
     *   2
     *  /
     * 1
     * Expected: [[4], [3], [2], [1]]
     */
    @Test
    @DisplayName("Test with a left-skewed tree")
    void traverse_withLeftSkewedTree_shouldReturnLevelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4,
                new BinaryTreeNode<>(3,
                        new BinaryTreeNode<>(2,
                                new BinaryTreeNode<>(1),
                                null),
                        null),
                null);
        List<List<Integer>> result = traverseTreeWithRoot(root);
        assertEquals(List.of(
                List.of(4),
                List.of(3),
                List.of(2),
                List.of(1)
        ), result);
    }

    /**
     * Tree:
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     * Expected: [[1], [2], [3], [4]]
     */
    @Test
    @DisplayName("Test with a right-skewed tree")
    void traverse_withRightSkewedTree_shouldReturnLevelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                null,
                new BinaryTreeNode<>(2,
                        null,
                        new BinaryTreeNode<>(3,
                                null,
                                new BinaryTreeNode<>(4))));
        List<List<Integer>> result = traverseTreeWithRoot(root);
        assertEquals(List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(4)
        ), result);
    }

    /**
     * Tree:
     *          10
     *        /    \
     *       5      15
     *      / \    /  \
     *     2   7  12  20
     * Expected: [[10], [5, 15], [2, 7, 12, 20]]
     */
    @Test
    @DisplayName("Test with a full binary tree")
    void traverse_withFullBinaryTree_shouldReturnLevelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5, new BinaryTreeNode<>(2), new BinaryTreeNode<>(7)),
                new BinaryTreeNode<>(15, new BinaryTreeNode<>(12), new BinaryTreeNode<>(20)));
        List<List<Integer>> result = traverseTreeWithRoot(root);
        assertEquals(List.of(
                List.of(10),
                List.of(5, 15),
                List.of(2, 7, 12, 20)
        ), result);
    }

    /**
     * Tree:
     *         10
     *        /   \
     *       5     15
     *        \   /
     *         8 12
     *            \
     *            11
     * Expected: [[10], [5, 15], [8, 12], [11]]
     */
    @Test
    @DisplayName("Test with an asymmetrical tree")
    void traverse_withAsymmetricalTree_shouldReturnLevelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5, null, new BinaryTreeNode<>(8)),
                new BinaryTreeNode<>(15, new BinaryTreeNode<>(12, null, new BinaryTreeNode<>(11)), null));
        List<List<Integer>> result = traverseTreeWithRoot(root);
        assertEquals(List.of(
                List.of(10),
                List.of(5, 15),
                List.of(8, 12),
                List.of(11)
        ), result);
    }

    /**
     * Tree with duplicate values:
     *         1
     *       /   \
     *      1     1
     *     / \     \
     *    1   1     1
     * Expected: [[1], [1, 1], [1, 1, 1]]
     */
    @Test
    @DisplayName("Test with duplicate values")
    void traverse_withDuplicateValues_shouldReturnLevelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                new BinaryTreeNode<>(1,
                        new BinaryTreeNode<>(1),
                        new BinaryTreeNode<>(1)),
                new BinaryTreeNode<>(1,
                        null,
                        new BinaryTreeNode<>(1)));
        List<List<Integer>> result = traverseTreeWithRoot(root);
        assertEquals(List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 1, 1)
        ), result);
    }

    /**
     * Tree:
     *    0
     *   /
     *  1
     * /
     * 2
     * ...
     * /
     * 1000
     * Expected: [[0], [1], [2], ..., [1000]]
     */
    @Test
    @DisplayName("Test with a deep tree (stress test for recursion and queue usage)")
    void traverse_withDeepTree_shouldReturnEachLevelIndividually() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> current = root;
        for (int i = 1; i <= 1000; i++) {
            BinaryTreeNode<Integer> next = new BinaryTreeNode<>(i);
            current.setLeftNode(next);
            current = next;
        }

        List<List<Integer>> result = traverseTreeWithRoot(root);
        assertEquals(1001, result.size());
        for (int i = 0; i <= 1000; i++) {
            assertEquals(List.of(i), result.get(i));
        }
    }

}
