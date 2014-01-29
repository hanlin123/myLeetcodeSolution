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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode runner = newHead.next.next;
        ListNode checker = newHead;
        
        while(runner!=null){
            if(runner.val==checker.next.val){
                while(runner!=null && runner.val==checker.next.val){
                    runner = runner.next;
                }
                checker.next = runner;
            }
            else{
                checker = checker.next;
            }
            if(runner!=null){
            	runner = runner.next;
            }
        }
        return newHead.next;
    }
}