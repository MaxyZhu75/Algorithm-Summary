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
    public TreeNode trimBST(TreeNode root, int low, int high) { // 递归，注意BST性质！！！
        if (root == null) return null; // 左右出口！！！
        if (root.val < low) { // case1：root比low小；由于root的左子树皆小于root，则root及其左子树需全部剪掉，然后继续修剪右子树！！！
            return trimBST(root.right, low, high);
        } else if (root.val > high) { // case2：root比high小；由于root的右子树皆大于root，则root及其右子树需全部剪掉，然后继续修剪左子树！！
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high); // case3：root在范围内；则root仍在BST中，且其左右子树应同样满足BST性质，因此继续对两边修剪！！！
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}