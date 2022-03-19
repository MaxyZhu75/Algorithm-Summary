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
    public int rangeSumBST(TreeNode root, int low, int high) { // 方法一：BFS遍历BST！！！
        int result = 0;
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            int nodeNum = bfsQueue.size();
            while (nodeNum-- > 0) {
                TreeNode currentNode = bfsQueue.poll();
                if (currentNode == null) continue;
                if (currentNode.val > high) {
                    bfsQueue.add(currentNode.left);
                } else if (currentNode.val < low) {
                    bfsQueue.add(currentNode.right);
                } else {
                    result += currentNode.val;
                    bfsQueue.add(currentNode.left);
                    bfsQueue.add(currentNode.right);
                }
            }
        }
        return result;
    }
}