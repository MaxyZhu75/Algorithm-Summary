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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;

        if (root.left == null || root.right == null) { // case1：单边为空（不是叶子），则用max()取不为空的那一边的最小深度；两边都为空的叶子节点返回结果必为1！！！
            result = Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            result = Math.min(minDepth(root.left), minDepth(root.right)) + 1; // case2：两边都不为空，则直接取两边递归的最小值再加1！！！
        }

        return result;
    }
}