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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) { // case1：边界，皆为空！！！
            return null;
        }
        if (root1 == null) { // case2：其中一个为空！！！
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val + root2.val); // case3：皆不为空！！！
        newRoot.left = mergeTrees(root1.left, root2.left); // recursion！！！
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }
}