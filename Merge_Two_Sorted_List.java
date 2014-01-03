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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)    return l2;
        if(l2==null)    return l1;
        
        ListNode anchor = null;
        ListNode endPoint = null;

        if(l1.val<=l2.val){
            anchor = l2;
            endPoint = l1;
        }else{
            anchor = l1;
            endPoint = l2;
        }
        while(anchor!=null && endPoint.next!=null){
            if(endPoint.next.val<=anchor.val){
                endPoint = endPoint.next;
            }else{
                ListNode tmp = anchor;
                anchor = endPoint.next;
                endPoint.next = tmp;
            }
        }
        if(endPoint.next==null)
            endPoint.next = anchor;
        return l1.val<=l2.val ? l1 : l2;
    }
}