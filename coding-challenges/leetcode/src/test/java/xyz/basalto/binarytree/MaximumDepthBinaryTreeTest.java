package xyz.basalto.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthBinaryTreeTest {

    private MaximumDepthBinaryTree maximumDepthBinaryTree;

    @BeforeEach
    public void setUp() {
        maximumDepthBinaryTree = new MaximumDepthBinaryTree();
    }

    @Test
    public void givenEmptyTree_whenMaxDepth_thenReturnZero() {
        // Given
        BinaryTree binaryTree = new BinaryTree();

        // When
        int result = maximumDepthBinaryTree.maxDepth(binaryTree);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void givenSingleNodeTree_whenMaxDepth_thenReturnOne() {
        // Given
        BinaryTreeNode root = new BinaryTreeNode(1, null, null);
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthBinaryTree.maxDepth(binaryTree);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void givenComplexTree_whenMaxDepth_thenReturnCorrectDepth() {
        // Given
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
        int result = maximumDepthBinaryTree.maxDepth(binaryTree);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void givenUnbalancedTree_whenMaxDepth_thenReturnCorrectDepth() {
        // Given
        BinaryTreeNode root = new BinaryTreeNode(1,
                new BinaryTreeNode(2,
                        new BinaryTreeNode(3,
                                new BinaryTreeNode(4, null, null),
                                null),
                        null),
                null);
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthBinaryTree.maxDepth(binaryTree);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void givenRightHeavyTree_whenMaxDepth_thenReturnCorrectDepth() {
        // Given
        BinaryTreeNode root = new BinaryTreeNode(1,
                null,
                new BinaryTreeNode(2,
                        null,
                        new BinaryTreeNode(3,
                                null,
                                new BinaryTreeNode(4, null, null))));
        BinaryTree binaryTree = new BinaryTree(root);

        // When
        int result = maximumDepthBinaryTree.maxDepth(binaryTree);

        // Then
        assertEquals(4, result);
    }
}