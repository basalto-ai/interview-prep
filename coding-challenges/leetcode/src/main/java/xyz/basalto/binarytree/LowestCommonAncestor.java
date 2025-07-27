package xyz.basalto.binarytree;

public class LowestCommonAncestor {

    public BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode x, BinaryTreeNode y) {
        // Base case: if the current node is null, there's nothing to search.
        if (root == null || root.value == x.value || root.value == y.value) {
            return root;
        }

        // Recursively search for x and y in the left subtree.
        BinaryTreeNode leftSearchResult = lca(root.left, x, y);

        // Recursively search for x and y in the right subtree.
        BinaryTreeNode rightSearchResult = lca(root.right, x, y);

        // If the left search returns null, it means neither x nor y was found in the left subtree.
        // So, the answer (if any) must be in the right subtree.
        if (leftSearchResult == null) {
            return rightSearchResult;
        }

        // Similarly, if the right search returns null, the answer must be in the left subtree.
        if (rightSearchResult == null) {
            return leftSearchResult;
        }

        // If both left and right subtrees return a non-null value,
        // it means x was found in one subtree and y in the other.
        // Therefore, the current node (root) is the lowest common ancestor.
        return root;
    }

}
