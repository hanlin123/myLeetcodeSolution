/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        
        TreeLinkNode pointer = root;
        TreeLinkNode scr = null;
        while(pointer!=null){
            if(pointer.left==null && pointer.right==null){
                pointer = pointer.next;
                continue;
            }
            if(pointer.left!=null && pointer.right!=null){
                pointer.left.next = pointer.right;
            }
            if(scr!=null){
                TreeLinkNode des = pointer.left==null ? pointer.right : pointer.left;
                scr.next = des;
            }
            scr = pointer.right==null ? pointer.left : pointer.right;
            pointer = pointer.next;
        }
        pointer = root;
        while(pointer.left==null && pointer.right==null && pointer.next!=null){
            pointer = pointer.next;
        }
        if(pointer.left!=null){
            connect(pointer.left);
        }else{
            connect(pointer.right);
        }
    }
}