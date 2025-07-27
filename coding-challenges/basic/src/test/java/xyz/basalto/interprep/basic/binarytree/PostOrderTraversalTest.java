package xyz.basalto.interprep.basic.binarytree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("PostOrderTraversal Tests")
class PostOrderTraversalTest {

    /**
     * Helper method to create a tree and invoke post-order traversal.
     */
    private List<Integer> traverseTreeWithRoot(BinaryTreeNode<Integer> root) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(root);
        return PostOrderTraversal.traverse(tree);
    }

    /**
     * Tests traversal on an empty tree.
     * Tree: null
     */
    @Test
    @DisplayName("Test with an empty tree")
    void traverse_withEmptyTree_shouldReturnEmptyList() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> result = PostOrderTraversal.traverse(tree);
        assertTrue(result.isEmpty());
    }

    /**
     * Tests traversal on a single-node tree.
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
     * Expected Post-Order: 1, 3, 2
     */
    @Test
    @DisplayName("Test with a balanced tree")
    void traverse_withBalancedTree_shouldReturnPostOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2,
                new BinaryTreeNode<>(1),
                new BinaryTreeNode<>(3));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(1, 3, 2), result);
    }

    /**
     * Tests traversal on a left-skewed tree.
     * Tree:
     *     5
     *    /
     *   4
     *  /
     * 3
     */
    /**
     * /
     * 2
     * Expected Post-Order: 2, 3, 4, 5
     */
    @Test
    @DisplayName("Test with a left-skewed tree")
    void traverse_withLeftSkewedTree_shouldReturnPostOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(4,
                        new BinaryTreeNode<>(3,
                                new BinaryTreeNode<>(2),
                                null),
                        null),
                null);
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(2, 3, 4, 5), result);
    }

    /**
     * Tests traversal on a right-skewed tree.
     * Tree:
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     * Expected Post-Order: 4, 3, 2, 1
     */
    @Test
    @DisplayName("Test with a right-skewed tree")
    void traverse_withRightSkewedTree_shouldReturnPostOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                null,
                new BinaryTreeNode<>(2,
                        null,
                        new BinaryTreeNode<>(3,
                                null,
                                new BinaryTreeNode<>(4))));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(4, 3, 2, 1), result);
    }

    /**
     * Tests traversal on a full binary tree.
     * Tree:
     *           10
     *         /    \
     *        5     15
     *       / \   /  \
     *      2   7 12  20
     * Expected Post-Order: 2, 7, 5, 12, 20, 15, 10
     */
    @Test
    @DisplayName("Test with a full binary tree")
    void traverse_withFullBinaryTree_shouldReturnPostOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5, new BinaryTreeNode<>(2), new BinaryTreeNode<>(7)),
                new BinaryTreeNode<>(15, new BinaryTreeNode<>(12), new BinaryTreeNode<>(20)));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(2, 7, 5, 12, 20, 15, 10), result);
    }

    /**
     * Tests traversal on an asymmetrical binary tree.
     * Tree:
     *          10
     *         /   \
     *        5     15
     *         \    /
     *          8  12
     *            /
     *           11
     * Expected Post-Order: 8, 5, 11, 12, 15, 10
     */
    @Test
    @DisplayName("Test with an asymmetrical tree")
    void traverse_withAsymmetricalTree_shouldReturnPostOrderList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5, null, new BinaryTreeNode<>(8)),
                new BinaryTreeNode<>(15,
                        new BinaryTreeNode<>(12, new BinaryTreeNode<>(11), null),
                        null));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(8, 5, 11, 12, 15, 10), result);
    }

    /**
     * Tests traversal on a tree with duplicate values.
     * Tree:
     *         1
     *       /   \
     *      1     1
     *     / \     \
     *    1   1     1
     * Expected Post-Order: 1, 1, 1, 1, 1, 1
     */
    @Test
    @DisplayName("Test with duplicate values")
    void traverse_withDuplicateValues_shouldReturnPostOrderList() {
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
     * Tests traversal on a very deep tree to verify recursive depth safety.
     * Tree:
     *     0
     *    /
     *   1
     *  /
     * 2
     * ...
     * /
     * 1000
     * Expected Post-Order: [1000, 999, ..., 0]
     */
    @Test
    @DisplayName("Test with a deep tree (stress test for recursion)")
    void traverse_withDeepTree_shouldReturnPostOrderList() {
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
            assertEquals(1000 - i, result.get(i));
        }
    }
}
