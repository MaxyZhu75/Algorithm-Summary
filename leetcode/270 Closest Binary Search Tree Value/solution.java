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
    public int closestValue(TreeNode root, double target) { // 由BST性质二分查找即可！！！
        int closest = root.val;
        while (root != null) {
			if (root.val == target) return root.val;
			closest = (Math.abs(root.val - target) < Math.abs(closest - target)) ? root.val : closest;
			root =  (target < root.val) ? root.left : root.right;
        }
        return closest;
    }
}