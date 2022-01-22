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
        if (root == null) { // ���ұ߽磡����
            return true;
        }
        if (Math.abs(treeHeight(root.left) - treeHeight(root.right)) > 1) { // ��balance�Ķ���д��������
            return false;
        }
        boolean balance = isBalanced(root.left) && isBalanced(root.right);  // �Զ�����recursion��������ڸ��Ž�Ϊ�Ե����ϣ�����
        return balance;
    }

    public int treeHeight(TreeNode root) { // �������ĸ߶ȣ�����
        if (root == null) {
            return 0;
        }
        int height = Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
        return height;
    }
}