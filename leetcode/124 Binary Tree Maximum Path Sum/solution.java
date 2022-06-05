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
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) { // 递归！！！
        recursion(root);
        return result;
    }

    public int recursion(TreeNode root) { // 注意：题目所需的result仅在递归中修改，而不是返回值；函数返回的是root到叶子的最大路径和！！！
        if (root == null) return 0;
        int left = Math.max(recursion(root.left), 0); // 分别获取左右子节点到叶子的最大路径和！！！
        int right = Math.max(recursion(root.right), 0);
        int current = root.val + left + right;
        result = Math.max(result, current);
        return root.val + Math.max(left, right); // 返回root到叶子的最大路径和！！！
    }
}