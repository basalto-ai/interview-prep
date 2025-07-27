package xyz.basalto.interprep.basic.binarytree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("PreOrderTraversal Tests")
class PreOrderTraversalTest {

    /**
     * Helper to build a tree and invoke traversal.
     */
    private List<Integer> traverseTreeWithRoot(BinaryTreeNode<Integer> root) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(root);
        return PreOrderTraversal.traverse(tree);
    }

    /**
     * Tests traversal on an empty tree.
     * Tree: null
     */
    @Test
    @DisplayName("Test with an empty tree")
    void traverse_withEmptyTree_shouldReturnEmptyList() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> result = PreOrderTraversal.traverse(tree);
        assertTrue(result.isEmpty());
    }

    /**
     * Tests traversal on a tree with only a single node.
     * Tree:
     *     42
     */
    @Test
    @DisplayName("Test with a single-node tree")
    void traverse_withSingleNodeTree_shouldReturnListWithSingleElement() {
        List<Integer> result = traverseTreeWithRoot(new BinaryTreeNode<>(42));
        assertEquals(List.of(42), result);
    }

    /**
     * Tests traversal on a balanced binary tree.
     * Tree:
     *       2
     *      / \
     *     1   3
     */
    @Test
    @DisplayName("Test with a balanced tree")
    void traverse_withBalancedTree_shouldReturnPreOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2,
                new BinaryTreeNode<>(1),
                new BinaryTreeNode<>(3));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(2, 1, 3), result);
    }

    /**
     * Tests traversal on a tree skewed to the left.
     * Tree:
     *     5
     *    /
     *   4
     *  /
     * 3
     */
    /**
     *  /
     * 2
     */
    @Test
    @DisplayName("Test with a left-skewed tree")
    void traverse_withLeftSkewedTree_shouldReturnPreOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(4,
                        new BinaryTreeNode<>(3,
                                new BinaryTreeNode<>(2),
                                null),
                        null),
                null);
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(5, 4, 3, 2), result);
    }

    /**
     * Tests traversal on a tree skewed to the right.
     * Tree:
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     */
    @Test
    @DisplayName("Test with a right-skewed tree")
    void traverse_withRightSkewedTree_shouldReturnPreOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                null,
                new BinaryTreeNode<>(2,
                        null,
                        new BinaryTreeNode<>(3,
                                null,
                                new BinaryTreeNode<>(4))));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(1, 2, 3, 4), result);
    }

    /**
     * Tests traversal on a full binary tree.
     * Tree:
     *           10
     *         /    \
     *       5       15
     *      / \     /  \
     *     2   7   12  20
     */
    @Test
    @DisplayName("Test with a full binary tree")
    void traverse_withFullBinaryTree_shouldReturnPreOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5, new BinaryTreeNode<>(2), new BinaryTreeNode<>(7)),
                new BinaryTreeNode<>(15, new BinaryTreeNode<>(12), new BinaryTreeNode<>(20)));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(10, 5, 2, 7, 15, 12, 20), result);
    }

    /**
     * Tests traversal on an asymmetrical tree.
     * Tree:
     *           10
     *         /    \
     *       5       15
     *        \     /
     *         8   12
     *            /
     *           11
     */
    @Test
    @DisplayName("Test with an asymmetrical tree")
    void traverse_withAsymmetricalTree_shouldReturnPreOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5, null, new BinaryTreeNode<>(8)),
                new BinaryTreeNode<>(15, new BinaryTreeNode<>(12, new BinaryTreeNode<>(11), null), null));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(10, 5, 8, 15, 12, 11), result);
    }

    /**
     * Tests traversal on a tree with duplicate values.
     * Tree:
     *         1
     *       /   \
     *      1     1
     *     / \     \
     *    1   1     1
     */
    @Test
    @DisplayName("Test with duplicate values")
    void traverse_withDuplicateValues_shouldReturnPreOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                new BinaryTreeNode<>(1,
                        new BinaryTreeNode<>(1),
                        new BinaryTreeNode<>(1)),
                new BinaryTreeNode<>(1,
                        null,
                        new BinaryTreeNode<>(1)));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(1, 1, 1, 1, 1, 1), result);
    }

    /**
     * Tests traversal on a deep left-linear tree to validate recursion stack limits.
     * Tree:
     *     0
     *    /
     *   1
     *  /
     * 2
     * .
     * .
     * .
     * 1000
     */
    @Test
    @DisplayName("Test with a deep tree (stress test for recursion)")
    void traverse_withDeepTree_shouldReturnPreOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> current = root;
        for (int i = 1; i <= 1000; i++) {
            BinaryTreeNode<Integer> next = new BinaryTreeNode<>(i);
            current.setLeftNode(next);
            current = next;
        }

        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(1001, result.size());
        for (int i = 0; i <= 1000; i++) {
            assertEquals(i, result.get(i));
        }
    }
}
