package xyz.basalto.binarytree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MergeTwoBinaryTree.
 */
public class MergeTwoBinaryTreeTest {

    // Helper method to compare two binary trees.
    private boolean isSameTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return t1.value == t2.value
                && isSameTree(t1.left, t1.left)
                && isSameTree(t1.right, t2.right);
    }

    /**
     * Give two simple trees when merged then returns a tree with summed nodes.
     */
    @Test
    public void givenTwoSimpleTrees_whenMerged_thenCorrectSumTree() {
        // Given
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTree tree1 = new BinaryTree(node1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTree tree2 = new BinaryTree(node2);
        MergeTwoBinaryTree merger = new MergeTwoBinaryTree();

        // When
        BinaryTree mergedTree = merger.mergeTrees(tree1, tree2);

        // Then
        assertNotNull(mergedTree);
        assertNotNull(mergedTree.root);
        assertEquals(3, mergedTree.root.value);
    }

    /**
     * Give a tree with a null root when merged then throws IllegalArgumentException.
     */
    @Test
    public void givenTreeWithNullRoot_whenMerged_thenThrowException() {
        // Given
        BinaryTree tree1 = new BinaryTree(null);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTree tree2 = new BinaryTree(node2);
        MergeTwoBinaryTree merger = new MergeTwoBinaryTree();

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            merger.mergeTrees(tree1, tree2);
        });
        assertTrue(exception.getMessage().contains("null"));
    }

    /**
     * Give two complex trees when merged then returns a correctly merged tree.
     *
     * Tree1:      1
     *           /   \
     *          3     2
     *         /
     *        5
     *
     * Tree2:      2
     *           /   \
     *          1     3
     *           \      \
     *            4      7
     *
     * Expected Merged Tree: 
     *             3
     *           /   \
     *          4     5
     *         / \      \
     *        5   4      7
     */
    @Test
    public void givenComplexTrees_whenMerged_thenMergedTreeIsCorrect() {
        // Given - Tree1
        BinaryTreeNode t1n5 = new BinaryTreeNode(5);
        BinaryTreeNode t1n3 = new BinaryTreeNode(3);
        t1n3.left = t1n5;
        BinaryTreeNode t1n2 = new BinaryTreeNode(2);
        BinaryTreeNode t1n1 = new BinaryTreeNode(1);
        t1n1.left = t1n3;
        t1n1.right = t1n2;
        BinaryTree tree1 = new BinaryTree(t1n1);

        // Given - Tree2
        BinaryTreeNode t2n4 = new BinaryTreeNode(4);
        BinaryTreeNode t2n1 = new BinaryTreeNode(1);
        t2n1.right = t2n4;
        BinaryTreeNode t2n7 = new BinaryTreeNode(7);
        BinaryTreeNode t2n3 = new BinaryTreeNode(3);
        t2n3.right = t2n7;
        BinaryTreeNode t2n2 = new BinaryTreeNode(2);
        t2n2.left = t2n1;
        t2n2.right = t2n3;
        BinaryTree tree2 = new BinaryTree(t2n2);

        MergeTwoBinaryTree merger = new MergeTwoBinaryTree();

        // When
        BinaryTree mergedTree = merger.mergeTrees(tree1, tree2);

        // Then - Expected merged tree construction
        BinaryTreeNode expectedLeft = new BinaryTreeNode(4);
        expectedLeft.left = new BinaryTreeNode(5);
        expectedLeft.right = new BinaryTreeNode(4);
        BinaryTreeNode expectedRight = new BinaryTreeNode(5);
        expectedRight.right = new BinaryTreeNode(7);
        BinaryTreeNode expectedRoot = new BinaryTreeNode(3);
        expectedRoot.left = expectedLeft;
        expectedRoot.right = expectedRight;

        assertTrue(isSameTree(expectedRoot, mergedTree.root));
    }


}
