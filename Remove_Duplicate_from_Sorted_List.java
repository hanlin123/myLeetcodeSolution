
 // Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
  }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)  return null;
        recursiveCheck(head, head.next, head.val);
        return head;
    }
    private static void recursiveCheck(ListNode lastNode, ListNode node, int last){
        if(node==null)  return;
        
        if(node.val == last){
            lastNode.next = node.next;
            recursiveCheck(lastNode, lastNode.next, last);
        }else{
            recursiveCheck(node, node.next, node.val);
        }
    }
}