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
	    	ListNode pointer = head;
	    	while(pointer.next!=null){
	    		pointer = pointer.next;
	    	}
	        return convertHelper(head, pointer);
	    }
	    private TreeNode convertHelper(ListNode start, ListNode end){
	        if(start==null || start.val>end.val){
	            return null;
	        }
	        
	        ListNode runner = start;
	        ListNode chaser = start;
	        ListNode tmp = new ListNode(Integer.MIN_VALUE);
	        tmp.next = chaser;
	        ListNode last = tmp;
	        
	        while(runner.next!=null && runner.val<end.val){
	            runner = runner.next;
	            if(runner.next==null || runner.val>=end.val){
	            	break;
	            }
	            runner = runner.next;
	            chaser = chaser.next;
	            last = last.next;
	        }
	        TreeNode node = new TreeNode(chaser.val);
	        node.left = convertHelper(start, last);
	        node.right = convertHelper(chaser.next, runner);
	        return node;
	    }
}