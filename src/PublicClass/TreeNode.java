package PublicClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
    public TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int i = 1; // Start from the second element in the array
        while (!queue.isEmpty() && i < array.length) {
            TreeNode currentNode = queue.poll();
            // Create the left child
            if (i < array.length && array[i] != null) {
                currentNode.left = new TreeNode(array[i]);
                queue.offer(currentNode.left);
            }
            i++;
            // Create the right child
            if (i < array.length && array[i] != null) {
                currentNode.right = new TreeNode(array[i]);
                queue.offer(currentNode.right);
            }
            i++;
        }
        return root;
    }
   public List<Integer> destructTree(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       if (root == null) {
           return result;
       }
       Queue<TreeNode> queue = new ArrayDeque<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           TreeNode node = queue.poll();
           result.add(node.key);
           if (node.left != null) {
               queue.offer(node.left);
           }
           if (node.right != null) {
               queue.offer(node.right);
           }
       }
       return result;
   }
}
