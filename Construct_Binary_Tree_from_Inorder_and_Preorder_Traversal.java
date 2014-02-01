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
    private static int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildHelper(preorder, inorder, 0, inorder.length-1);
    }
    private TreeNode buildHelper(int[] preorder, int[] inorder, int start, int end){
        if(start>end || index>=preorder.length){
            index--;
            return null;
        }
        int i = searchValue(inorder, start, end, preorder[index]);
        if(i<0){
            index--;
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left = buildHelper(preorder, inorder, start, i-1);
        index++;
        node.right = buildHelper(preorder, inorder, i+1, end);
        return node;
    }
    private int searchValue(int[] array, int start, int end, int target){
    	int result = -1;
    	for(int i=start;i<=end;i++){
    		if(array[i]==target){
    			return i;
    		}
    	}
    	return result;
    }
}