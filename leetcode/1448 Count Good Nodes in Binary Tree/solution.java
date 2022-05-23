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
    public int goodNodes(TreeNode root) {
        return 1 + goodNode(root.left, root.val) + goodNode(root.right, root.val);
    }

    public int goodNode(TreeNode root, int maxVal) { // 在递归函数中传递路径中的最大值！！！
        if (root == null) return 0;
        int current = 0;
        if (root.val >= maxVal) {
            current = 1;
            maxVal = root.val;
        }
        return current + goodNode(root.left, maxVal) + goodNode(root.right, maxVal);
    }
}