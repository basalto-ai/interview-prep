package xyz.basalto.interprep.basic.binarytree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xyz.basalto.interprep.ds.BinaryTree;
import xyz.basalto.interprep.ds.BinaryTreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("InorderTraversal Tests")
class InorderTraversalTest {

    /**
     * Helper method to reduce boilerplate by wrapping the root node in a tree
     * and running the traversal.
     *
     * @param root The root node of the tree to traverse.
     * @return The list of values from the inorder traversal.
     */
    private List<Integer> traverseTreeWithRoot(BinaryTreeNode<Integer> root) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(root);
        return InorderTraversal.traverse(tree);
    }

    /**
     * Tests traversal on a null tree.
     * Tree: null
     */
    @Test
    @DisplayName("Test with an empty tree")
    void traverse_withEmptyTree_shouldReturnEmptyList() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> result = InorderTraversal.traverse(tree);
        assertTrue(result.isEmpty());
    }

    /**
     * Tests traversal on a tree with only a single node.
     * Tree:  42
     */
    @Test
    @DisplayName("Test with a single-node tree")
    void traverse_withSingleNodeTree_shouldReturnListWithSingleElement() {
        List<Integer> result = traverseTreeWithRoot(new BinaryTreeNode<>(42));
        assertEquals(List.of(42), result);
    }

    /**
     * Tests traversal on a simple, balanced binary tree.
     * <pre>
     *       2
     *      / \
     *     1   3
     * </pre>
     */
    @Test
    @DisplayName("Test with a balanced tree")
    void traverse_withBalancedTree_shouldReturnSortedList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2,
                new BinaryTreeNode<>(1),
                new BinaryTreeNode<>(3));
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(1, 2, 3), result);
    }

    /**
     * Tests traversal on a tree that is skewed to the left.
     * <pre>
     *       5
     *      /
     *     4
     *    /
     *   3
     *  /
     * 2
     * </pre>
     */
    @Test
    @DisplayName("Test with a left-skewed tree")
    void traverse_withLeftSkewedTree_shouldReturnSortedList() {
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
     * Tests traversal on a tree that is skewed to the right.
     * <pre>
     *     1
     *      \
     *       2
     *        \
     *         3
     *          \
     *           4
     * </pre>
     */
    @Test
    @DisplayName("Test with a right-skewed tree")
    void traverse_withRightSkewedTree_shouldReturnSortedList() {
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
     * <pre>
     *          10
     *        /    \
     *       5     15
     *      / \   /  \
     *     2   7 12  20
     * </pre>
     */
    @Test
    @DisplayName("Test with a full binary tree")
    void traverse_withFullBinaryTree_shouldReturnSortedList() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5, new BinaryTreeNode<>(2), new BinaryTreeNode<>(7)),
                new BinaryTreeNode<>(15, new BinaryTreeNode<>(12), new BinaryTreeNode<>(20))
        );
        List<Integer> result = traverseTreeWithRoot(root);
        assertEquals(List.of(2, 5, 7, 10, 12, 15, 20), result);
    }

}
