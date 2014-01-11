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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursiveAdd(l1, l2, 0);
    }
    private static ListNode recursiveAdd(ListNode l1, ListNode l2, int carry){
        if(l1==null && l2==null){
            if(carry==0)    return null;
            else            return new ListNode(1);
        }
        if(l1!=null && l2!=null){
            ListNode newNode = new ListNode(l1.val+l2.val+carry);
            int newCarry = newNode.val/10;
            newNode.val %= 10;
            newNode.next = recursiveAdd(l1.next, l2.next, newCarry);
            return newNode;
        }
        if(l1==null){
            ListNode newNode = new ListNode(l2.val+carry);
            int newCarry = newNode.val/10;
            newNode.val %= 10;
            newNode.next = recursiveAdd(l1, l2.next, newCarry);
            return newNode;
        }else{
            ListNode newNode = new ListNode(l1.val+carry);
            int newCarry = newNode.val/10;
            newNode.val %= 10;
            newNode.next = recursiveAdd(l1.next, l2, newCarry);
            return newNode;
        }
    }
}