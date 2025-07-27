package xyz.basalto.interprep.ds;

public class BinaryTree<T> {

    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTreeNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public int getSize() {
        return this.size;
    }

}
