/*
 * corners:
 * 1. each value of nodes need to be in the range set by earilier nodes
 * 2. the equal nodes are not valid. 
 */


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
    public boolean isValidBST(TreeNode root) {
 			 return checkHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean checkHelper(TreeNode node, int min, int max){
    	if(node==null){
    		return true;
    	}
    	if(node.val<=min || node.val>=max){
    		return false;
    	}
    	boolean valid = true;
    	if(node.left!=null){
    		if(node.left.val>=node.val){
    			return false;
    		}
    		valid &= checkHelper(node.left, min, node.val);
    	}
    	if(!valid){
    		return false;
    	}
    	if(node.right!=null){
    		if(node.right.val<=node.val){
    			return false;
    		}
    		valid &= checkHelper(node.right, node.val, max);
    	}

    	return valid;
    }
 }