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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        traversalHelper(root, result);
        return result;
    }
    private void traversalHelper(TreeNode node, ArrayList<Integer> result){
        if(node==null){
            return;
        }
        traversalHelper(node.left, result);
        result.add(node.val);
        traversalHelper(node.right, result);
        return;
    }
}
}