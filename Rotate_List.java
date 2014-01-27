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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || head.next==null)  return head;
        // get the size
        int size = 0;
        ListNode node = head;
        while(node!=null)   {size++; node = node.next;}
        
        int pos = n%size;
        if(pos==0)  return head;
        if(size==2){
            ListNode newHead = head.next;
            newHead.next = head;
            head.next = null;
            return newHead;
        }
        ListNode runner = head.next;
        ListNode chaser = head;
        for(int i=0;i<pos;i++)    {runner = runner.next; chaser = chaser.next;}
        ListNode newTail = head;
        while(runner!=null){
            runner = runner.next;
            chaser = chaser.next;
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        chaser.next = head;
        newTail.next = null;
        return newHead;
    }
}