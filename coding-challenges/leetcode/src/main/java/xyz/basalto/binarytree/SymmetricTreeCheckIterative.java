package xyz.basalto.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


public class SymmetricTreeCheckIterative {
    
    public boolean isSymmetricTree(BinaryTree binaryTree){
        Objects.requireNonNull(binaryTree);
        BinaryTreeNode root = Objects.requireNonNull(binaryTree.root);
        
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            BinaryTreeNode node1 = queue.poll();
            BinaryTreeNode node2 = queue.poll();

            if (node1 == null && node2 == null){
                continue;
            }

            if (node1 == null || node2 == null || node1.value != node2.value){
                return false;
            }

            queue.add(node1.left);
            queue.add(node2.right);

            queue.add(node1.right);
            queue.add(node2.left);
        }

        return true;
    }
}
