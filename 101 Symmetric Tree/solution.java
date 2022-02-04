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
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root.left, root.right); // 该题根节点不为空！！！
    }

    public boolean isEqual(TreeNode root1, TreeNode root2) { // 递归方法！！！
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        } 
        if (root1.val != root2.val) {
            return false;
        }
        
        boolean result = isEqual(root1.left, root2.right) && isEqual(root1.right, root2.left);
        return result;
    }
}