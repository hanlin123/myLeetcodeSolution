/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 1. ArrayList clone() is shallow copy
// 2. remove element in the array will affect the following index --> don't use remove in for loop
// 3. set element as null wont affect index
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null)  return result;
        
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        result.add(newArray);
        recursiveCheck(root, sum, result, 0);
        int index = 0;
        int size = result.size();
        while(index<size){
            if(result.get(index)==null){
                result.remove(index);
                index--;
                size--;
            }
            index++;
        }
        return result;
    }
    private static void recursiveCheck(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, int index){
        result.get(index).add(node.val);
        if(node.left==null && node.right==null){
            int tmp = 0;
            for(Integer i : result.get(index))
                tmp += i;
            if(tmp!=sum)    result.set(index, null);
        }else if(node.left!=null && node.right!=null){
            ArrayList<Integer> newArray = new ArrayList<Integer>();
            deepCopy(result.get(index), newArray);
            result.add(newArray);
            recursiveCheck(node.right, sum, result, result.size()-1);
            recursiveCheck(node.left, sum, result, index);
        }else if(node.left==null){
            recursiveCheck(node.right, sum, result, index);
        }else{
            recursiveCheck(node.left, sum, result, index);
        }
    }
    private static void deepCopy(ArrayList<Integer> src, ArrayList<Integer> des){
    	for(Integer i : src)
    		des.add(i);
    }
}