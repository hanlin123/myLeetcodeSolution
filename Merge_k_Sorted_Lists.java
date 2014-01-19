/*
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null || lists.size()==0) return null;
        ListNode[] firstNodes = new ListNode[lists.size()];
        for(int i=0; i<lists.size();i++)	firstNodes[i] = lists.get(i);
        ListNode head = new ListNode(0);
       	ListNode pointer = head;
       	
        Arrays.sort(firstNodes, new NodeComparator());
      	while(firstNodes[0]!=null){
      		if(firstNodes[0]==null) break;
      		pointer.next = firstNodes[0];
      		pointer = pointer.next;
      		firstNodes[0] = firstNodes[0].next;
      		Arrays.sort(firstNodes, new NodeComparator());
      	}
      	return head.next;
    }

   	public static class NodeComparator implements Comparator<ListNode>{
   		@Override
			public int compare(ListNode arg0, ListNode arg1) {
				if(arg0==null	&& arg1==null)	return 0;
				else if(arg0==null)						return 1;
				else if(arg1==null)						return -1;
				else													return arg0.val - arg1.val;
			}
   	}
}
