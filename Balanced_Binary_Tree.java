
  // Definition for binary tree
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        int result = recursiveCheck(root);
        if(result<0)    return false;
        else            return true;
    }
    private static int recursiveCheck(TreeNode node){
        if(node==null)  return 0;
        
        int leftResult = recursiveCheck(node.left);
        int rightResult = recursiveCheck(node.right);
        if(leftResult<0 || rightResult<0)   return -1;
        if(Math.abs(leftResult-rightResult)>1)  return -1;
        return Math.max(leftResult, rightResult)+1;
    }
}