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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { // 左右出口！！！
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right); // 传入另一边的子节点进行recursion即可！！！
        root.right = invertTree(temp);
        return root;
    }
}