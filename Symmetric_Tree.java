
  // Definition for binary tree
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        return recursiveCheck(root.left, root.right);
    }
    private static boolean recursiveCheck(TreeNode leftChecker, TreeNode rightChecker){
        if(leftChecker==null && rightChecker==null)     return true;
        if(leftChecker==null || rightChecker==null)     return false;
        
        if(leftChecker.val!=rightChecker.val)       return false;
        return recursiveCheck(leftChecker.left, rightChecker.right)&&recursiveCheck(leftChecker.right, rightChecker.left);
    }
}