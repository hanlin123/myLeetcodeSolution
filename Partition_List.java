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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }
        
        //search the pivet
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pivet = newHead;
        ListNode search = pivet.next;
        
        while(pivet.next!=null && pivet.next.val<x){
            search = search.next;
            pivet = pivet.next;
        }
        // all the node value are less than x
        if(search==null){
            return head;
        }
        
        while(search.next!=null){
            if(search.next.val < x){
                ListNode target = search.next;
                ListNode des = pivet.next;
                pivet.next = target;
                search.next = target.next;
                target.next = des;
                pivet = target;
            }else{
                search = search.next;
            }
        }
        
        return newHead.next;
    }
}