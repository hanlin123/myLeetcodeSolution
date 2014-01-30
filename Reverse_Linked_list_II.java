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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head ==null || m==n){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode runner = newHead;
        int i = 1;
        for(; i<m; i++){
            runner = runner.next;
        }
        ListNode pointer = runner;
        for(;i<=n;i++){
            runner = runner.next;
        }
        for(int j=0;j<n-m;j++){
            ListNode target = pointer.next;
            pointer.next = target.next;
            target.next = runner.next;
            runner.next = target;
        }
        return newHead.next;
    }
}