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
    private static class Node{
        TreeNode treenode;
        int level;
        public Node(TreeNode _treenode, int _level){
            treenode = _treenode;
            level = _level;
        }
    }
    private static LinkedList<Node> stack;
    private static LinkedList<Node> queue;
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return results;
        }
        
        stack = new LinkedList<Node>();
        queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));
        while(queue.size()!=0){
            Node node = queue.poll();
            if(node.treenode.right!=null){
                queue.offer(new Node(node.treenode.right, node.level+1));
            }
            if(node.treenode.left!=null){
                queue.offer(new Node(node.treenode.left, node.level+1));
            }
            stack.push(node);
        }
        int level = Integer.MAX_VALUE;
        while(stack.size()!=0){
            Node node = stack.pop();
            if(node.level!=level){
                results.add(new ArrayList<Integer>());
                level = node.level;
            }
            results.get(results.size()-1).add(node.treenode.val);
        }
        return results;
    }
}