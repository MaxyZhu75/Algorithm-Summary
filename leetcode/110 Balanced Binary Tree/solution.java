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
    public boolean isBalanced(TreeNode root) {
        if (root == null) { // 左右边界！！！
            return true;
        }
        if (Math.abs(treeHeight(root.left) - treeHeight(root.right)) > 1) { // 由balance的定义写出！！！
            return false;
        }
        boolean balance = isBalanced(root.left) && isBalanced(root.right);  // 自顶向下recursion；该题存在更优解为自底向上！！！
        return balance;
    }

    public int treeHeight(TreeNode root) { // 计算树的高度！！！
        if (root == null) {
            return 0;
        }
        int height = Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
        return height;
    }
}