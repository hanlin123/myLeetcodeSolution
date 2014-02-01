/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static class Node{
        TreeNode treenode;
        int level;
        public Node(TreeNode _treenode, int _level){
            treenode = _treenode;
            level = _level;
        }
    }
    private static LinkedList<Node> queue;
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return results;
        }
        
        queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));
        while(queue.size()!=0){
            Node node = queue.poll();
            if(node.treenode.left!=null){
                queue.offer(new Node(node.treenode.left, node.level+1));
            }
            if(node.treenode.right!=null){
                queue.offer(new Node(node.treenode.right, node.level+1));
            }
            if(node.level<results.size()){
                results.get(node.level).add(node.treenode.val);
            }else{
                results.add(node.level, new ArrayList<Integer>());
                results.get(node.level).add(node.treenode.val);
            }
        }
        return results;
    }
}