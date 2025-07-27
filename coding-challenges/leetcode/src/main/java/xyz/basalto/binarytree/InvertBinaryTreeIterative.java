package xyz.basalto.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class InvertBinaryTreeIterative {

    public void invert(BinaryTree binaryTree){
        Objects.requireNonNull(binaryTree);
        BinaryTreeNode root = Objects.requireNonNull(binaryTree.root);

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();

            // swap
            BinaryTreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }
        }
    }

}
