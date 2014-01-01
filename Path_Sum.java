
// Definition for binary tree
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
 
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)  return false;
        if(root.left==null&&root.right==null&&root.val==sum)
            return true;
            
        return recursiveCheck(root.left, root.val, sum)||recursiveCheck(root.right, root.val, sum);
    }
    private static boolean recursiveCheck(TreeNode node, int lastSum, int sum){
        if(node==null)      return false;
        
        int currentSum = lastSum + node.val;
        if(node.left==null&&node.right==null){
            if(currentSum==sum)     return true;
            else                    return false;
        }
        
        return recursiveCheck(node.left, currentSum, sum)||recursiveCheck(node.right, currentSum, sum);
    }
}