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
    public int sumNumbers(TreeNode root) {
        if(root==null)  return 0;
        return recursiveAdd(root, 0);
    }
    private int recursiveAdd(TreeNode node, int num){
        int result = num*10+node.val;
        if(node.left==null && node.right==null) 
            return result;
        if(node.left!=null && node.right!=null) 
            return recursiveAdd(node.left, result) + recursiveAdd(node.right, result);
        return node.left==null ? recursiveAdd(node.right, result) : recursiveAdd(node.left, result);
    }
}