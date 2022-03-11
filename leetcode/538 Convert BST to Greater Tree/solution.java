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
    int valueRecoed;
    
    public TreeNode convertBST(TreeNode root) { // 该题在遍历顺序：右根左的基础上进行操作即可！！！
        valueRecoed = 0;
        inorderReverse(root);
        return root;
    }

    public void inorderReverse(TreeNode root) { // 此处相当于反转中序遍历（中序遍历：左根右）！！！
        if (root == null) return;
        inorderReverse(root.right);
        valueRecoed += root.val;
        root.val = valueRecoed;
        inorderReverse(root.left);
    }
}