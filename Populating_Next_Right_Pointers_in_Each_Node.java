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
        while(pointer!=null){
            if(pointer.left!=null && pointer.right!=null){
                pointer.left.next = pointer.right;
            }
            TreeLinkNode nextNode = pointer.next;
            if(nextNode!=null && nextNode.left!=null){
                pointer.right.next = nextNode.left;
            }
            pointer = nextNode;
        }
        connect(root.left);
    }
}