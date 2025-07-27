package xyz.basalto.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthIterativeBinaryTree {

    public int maxDepth(BinaryTree binaryTree) {
        if (binaryTree.root == null) return 0;

        
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(binaryTree.root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 
            
            // Process all nodes in the current level.
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            depth++;
        }

        return depth;
    }
        

   

}
