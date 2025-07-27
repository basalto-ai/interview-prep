package xyz.basalto.binarytree;

public class IsSameTree {

    public boolean isSameTree(BinaryTree a, BinaryTree b){
        return isSameTree(a.root, b.root);
    }

    private boolean isSameTree(BinaryTreeNode a, BinaryTreeNode b){
        if(a == b) {
            return true;
        }
        
        if(a == null || b == null){
            return false;
        }

        if(a.value != b.value){
            return false;
        }

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

}
