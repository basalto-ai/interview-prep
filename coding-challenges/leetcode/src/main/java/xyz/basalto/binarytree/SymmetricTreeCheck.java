package xyz.basalto.binarytree;

import java.util.Objects;

public class SymmetricTreeCheck {

    public boolean isSymmetricTree(BinaryTree binaryTree){
        Objects.requireNonNull(binaryTree);
        Objects.requireNonNull(binaryTree.root);
        
        return isMirror(binaryTree.root.left, binaryTree.root.right);
    }

    private boolean isMirror(BinaryTreeNode left, BinaryTreeNode right){
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.value != right.value){
            return false;
        }

        return isMirror(left.left, left.right) && isMirror(right.right, right.left);
    }
}
