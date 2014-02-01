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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        return buildHelper(postorder, inorder, 0, inorder.length-1);
    }
    private TreeNode buildHelper(int[] postorder, int[] inorder, int start, int end){
        if(start>end || index<0){
            index++;
            return null;
        }
        int i = searchValue(inorder, start, end, postorder[index]);
        if(i<0){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(postorder[index]);
        index--;
        node.right = buildHelper(postorder, inorder, i+1, end);
        index--;
        node.left = buildHelper(postorder, inorder, start, i-1);
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