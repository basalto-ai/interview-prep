package xyz.basalto.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthIterativeBinaryTreeTest {

    private MaximumDepthIterativeBinaryTree maximumDepthIterative;

    @BeforeEach
    public void setUp() {
        maximumDepthIterative = new MaximumDepthIterativeBinaryTree();
    }

    @Test
    public void givenEmptyTree_whenMaxDepthIteratively_thenReturnZero() {
        // Given
        BinaryTree binaryTree = new BinaryTree();

        // When
        int result = maximumDepthIterative.maxDepth(binaryTree);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void givenSingleNodeTree_whenMaxDepthIteratively_thenReturnOne() {
        // Given
        BinaryTreeNode root = new BinaryTreeNode(1, null, null);
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthIterative.maxDepth(binaryTree);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void givenComplexTree_whenMaxDepthIteratively_thenReturnCorrectDepth() {
        // Given
        // Constructing a complex binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6
        //   /
        //  7
        BinaryTreeNode root = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(4,
                                new BinaryTreeNode(7, null, null),
                                null),
                        new BinaryTreeNode(5, null, null)),
                new BinaryTreeNode(3,
                        null,
                        new BinaryTreeNode(6, null, null)));
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthIterative.maxDepth(binaryTree);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void givenUnbalancedLeftHeavyTree_whenMaxDepthIteratively_thenReturnCorrectDepth() {
        // Given
        // Constructing an unbalanced tree:
        //         1
        //        /
        //       2
        //      /
        //     3
        //    /
        //   4
        BinaryTreeNode root = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(3,
                                new BinaryTreeNode(4, null, null),
                                null),
                        null),
                null);
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthIterative.maxDepth(binaryTree);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void givenRightHeavyTree_whenMaxDepthIteratively_thenReturnCorrectDepth() {
        // Given
        // Constructing a right heavy tree:
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        BinaryTreeNode root = new BinaryTreeNode(1,
                null,
                new BinaryTreeNode(2,
                        null,
                        new BinaryTreeNode(3,
                                null,
                                new BinaryTreeNode(4, null, null))));
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthIterative.maxDepth(binaryTree);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void givenMixedStructureTree_whenMaxDepthIteratively_thenReturnCorrectDepth() {
        // Given
        // Constructing a mixed tree structure:
        //            1
        //          /   \
        //         2     3
        //        /     /
        //       5     4
        //        \      \
        //         7      6
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node5, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, node6);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node4, null);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthIterative.maxDepth(binaryTree);

        // Then
        // The maximum depth is 4 (path: 1->2->5->7 or 1->3->4->6)
        assertEquals(4, result);
    }
}