package xyz.basalto.interprep.ds;

public class BinaryTreeNode<T> {

    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return this.value;
    }

    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    public void setLeftNode(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRightNode(BinaryTreeNode<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BinaryTreeNode)) return false;
        BinaryTreeNode other = (BinaryTreeNode) obj;
        return value == other.value &&
                (left == null ? other.left == null : left.equals(other.left)) &&
                (right == null ? other.right == null : right.equals(other.right));
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
    
}

