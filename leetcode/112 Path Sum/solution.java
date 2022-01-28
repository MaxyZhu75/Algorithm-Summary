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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) { // 左右边界！！！
            return false;
        }

        int nextTarget = targetSum - root.val;
        if (nextTarget == 0 && root.left == null && root.right == null) { // 两个条件：路径和为0且为叶子节点！！！
            return true;
        }

        return hasPathSum(root.left, nextTarget) || hasPathSum(root.right, nextTarget); // recursion！！！
    }
}