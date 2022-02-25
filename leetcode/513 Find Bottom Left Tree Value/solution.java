/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) { // BFS层序遍历；注意最底层最左边节点，不一定是左子节点，只要最左边即可！！！
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        
        TreeNode currentNode = null;
        while (!bfsQueue.isEmpty()) { // 每层入队时先右后左，则最后一个出队的节点必是在树的最底层最左边！！！
            currentNode = bfsQueue.poll();
            if (currentNode.right != null) bfsQueue.add(currentNode.right);
            if (currentNode.left != null) bfsQueue.add(currentNode.left);
        }
        return currentNode.val;
    }
}