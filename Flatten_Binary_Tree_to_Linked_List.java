/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        flattenHelper(root, queue);
        
        TreeNode pointer = queue.poll();
        pointer.left = null;
        while(queue.size()!=0){
            TreeNode node = queue.poll();
            pointer.right = node;
            pointer = pointer.right;
            pointer.left = null;
        }
        return;
    }
    private void flattenHelper(TreeNode node, LinkedList<TreeNode> queue){
        if(node==null){
            return;
        }
        queue.offer(node);
        flattenHelper(node.left, queue);
        flattenHelper(node.right, queue);
    }
}