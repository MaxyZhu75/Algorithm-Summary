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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) { // 左右出口！！！
            return 0;
        }

        int result = 0;
        if (isLeaf(root.left)) {
            result = root.left.val + sumOfLeftLeaves(root.right); // case1：左子结点为叶子！！！
        } else {
            result = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right); // case2：左子节点不为叶子！！！
        }

        return result;
    }

    public boolean isLeaf(TreeNode root) { // 写辅助方法来判断是否为叶子！！！
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return false;
    }
}