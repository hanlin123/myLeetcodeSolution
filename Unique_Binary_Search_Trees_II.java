/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
    	ArrayList<TreeNode> results = generateHelper(0, n);
    	return results;
    }
    private ArrayList<TreeNode> generateHelper(int start, int end){
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	if(start==end){
    		result.add(null);
    		return result;
    	}
    	if((end-start)==1){
    		result.add(new TreeNode(end));
    		return result;
    	}
    	for(int i=start; i<end;i++){
    		TreeNode node = new TreeNode(i+1);
    		ArrayList<TreeNode> leftResult = generateHelper(start, i);
    		ArrayList<TreeNode> rightResult = generateHelper(i+1, end);
    		for(TreeNode nl : leftResult){
    			for(TreeNode nr : rightResult){
    				node.left = nl;
    				node.right = nr;
    				TreeNode newNode = copyTree(node);
    				result.add(newNode);
    			}
    		}
    	}
    	return result;
    }
    private TreeNode copyTree(TreeNode head){
        if(head==null){
            return null;
        }
        TreeNode newHead = new TreeNode(head.val);
        newHead.left = copyTree(head.left);
        newHead.right = copyTree(head.right);
        return newHead;
    }
}