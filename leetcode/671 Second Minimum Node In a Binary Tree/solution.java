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
    int result = -1; // 结果设为全局变量！！！
    int rootVal;
    
    public int findSecondMinimumValue(TreeNode root) { // 二叉树的DFS遍历！！！
        rootVal = root.val;
        treeDFS(root);
        return result;
    }

    public void treeDFS(TreeNode root) { // 递归写DFS！！！
        if (root == null) { // 左右出口！！！
            return;
        }

        int currentVal = root.val;
        if (result != -1 && currentVal > result) { // case1：result已修改过且当前结点值大于result，则直接return！！！
            return;
        }

        if (currentVal > rootVal) { // case2：result未修改过且当前结点值大于根节点值，记录result！！！
            result = currentVal;
        }

        treeDFS(root.left); // recursion！！！
        treeDFS(root.right);
    }
}