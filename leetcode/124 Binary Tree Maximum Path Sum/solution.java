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
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) { // �ݹ飡����
        recursion(root);
        return result;
    }

    public int recursion(TreeNode root) { // ע�⣺��Ŀ�����result���ڵݹ����޸ģ������Ƿ���ֵ���������ص���root��Ҷ�ӵ����·���ͣ�����
        if (root == null) return 0;
        int left = Math.max(recursion(root.left), 0); // �ֱ��ȡ�����ӽڵ㵽Ҷ�ӵ����·���ͣ�����
        int right = Math.max(recursion(root.right), 0);
        int current = root.val + left + right;
        result = Math.max(result, current);
        return root.val + Math.max(left, right); // ����root��Ҷ�ӵ����·���ͣ�����
    }
}