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
    public TreeNode sortedArrayToBST(int[] num) {
        return recursiveBuild(num, 0, num.length-1);
    }
    private static TreeNode recursiveBuild(int[] num, int start, int end){
        if(start>end)   return null;
        int middle = (start+end)/2;
        TreeNode node = new TreeNode(num[middle]);
        node.left = recursiveBuild(num, start, middle-1);
        node.right = recursiveBuild(num, middle+1, end);
        return node;
    }
}