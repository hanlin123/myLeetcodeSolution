/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
      public TreeNode sortedListToBST(ListNode head) {
    			if(head==null){
    				return null;
    			}
    			ArrayList<Integer> array = new ArrayList<Integer>();
    			ListNode pointer = head;
    			while(pointer!=null){
    				array.add(pointer.val);
    				pointer = pointer.next;
    			}
	        return convertHelper(0, array.size()-1, array);
	    }
	    private TreeNode convertHelper(int start, int end, ArrayList<Integer> array){
	        if(start>end){
	        	return null;
	        }

	        int mid = (start+end)/2;
	        TreeNode node = new TreeNode(array.get(mid));
	        node.left = convertHelper(start, mid-1, array);
	        node.right = convertHelper(mid+1, end, array);
	        return node;
	    }
}