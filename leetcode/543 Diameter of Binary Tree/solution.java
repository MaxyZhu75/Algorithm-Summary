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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) { // 左右边界！！！
            return 0;
        }
        int current = treeHeight(root.left) + treeHeight(root.right); // 该recursion由树的diameter定义得出！！！
        int diameter = triMax(current, diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)); // 由于diameter的路径不一定过原本的根节点，此处需要使用recursion，比较并取出最大值！！！
        return diameter;
    }

    public int treeHeight(TreeNode root) { // 经典求树的高度！！！
        if (root == null) {
            return 0;
        }
        int height = Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
        return height;
    }

    public int triMax(int a, int b, int c) { // 手写三个数取最大值！！！
        if (a>=b && a>=c) {
            return a;
        } else if (b>=a && b>=c) {
            return b;
        } else {
            return c;
        }
    }
}