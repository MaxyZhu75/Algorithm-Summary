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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;

        if (root.left == null || root.right == null) { // case1������Ϊ�գ�����Ҷ�ӣ�������max()ȡ��Ϊ�յ���һ�ߵ���С��ȣ����߶�Ϊ�յ�Ҷ�ӽڵ㷵�ؽ����Ϊ1������
            result = Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        } else {
            result = Math.min(minDepth(root.left), minDepth(root.right)) + 1; // case2�����߶���Ϊ�գ���ֱ��ȡ���ߵݹ����Сֵ�ټ�1������
        }

        return result;
    }
}