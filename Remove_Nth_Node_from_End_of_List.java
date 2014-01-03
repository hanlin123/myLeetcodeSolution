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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head;
        ListNode target = head;
        ListNode chaser = head;
        
        for(int i=1; i<n; i++)  runner = runner.next;
        for(int i=0; i<2; i++){
            if(runner==null){
                head = target;
                return head;
            }
            runner = runner.next;
            target = target.next;
        }
        while(runner!=null){
            runner = runner.next;
            target = target.next;
            chaser = chaser.next;
        }
        chaser.next = target;
        return head;
    }
}