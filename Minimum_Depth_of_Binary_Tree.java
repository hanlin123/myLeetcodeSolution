
// Definition for binary tree
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
 
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)  return 0;
        int leftResult = minDepth(root.left);
        int rightResult = minDepth(root.right);
        
        if(leftResult==0)   return rightResult+1;
        if(rightResult==0)  return leftResult+1;
        return Math.min(leftResult, rightResult)+1;
    }
}