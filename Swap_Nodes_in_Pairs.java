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
    public ListNode swapPairs(ListNode head) {
        if(head==null)  return null;
        int count = 1;
        
        ListNode runner = head;
        ListNode startPoint = null;
        ListNode chaser = startPoint;
        while(runner!=null){
            if(runner.next!=null){
                ListNode tmp = runner.next;
                runner.next = tmp.next;
                tmp.next = runner; 
                if(startPoint==null)    startPoint = tmp;
                else					chaser.next = tmp;
            }
            chaser = runner;
            runner = runner.next;
            if(startPoint==null)    startPoint = chaser;
        }
        return startPoint;
    }
}