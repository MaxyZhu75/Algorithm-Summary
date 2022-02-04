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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) { // ���ҳ��ڣ�����
            return 0;
        }

        int result = 0;
        if (isLeaf(root.left)) {
            result = root.left.val + sumOfLeftLeaves(root.right); // case1�����ӽ��ΪҶ�ӣ�����
        } else {
            result = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right); // case2�����ӽڵ㲻ΪҶ�ӣ�����
        }

        return result;
    }

    public boolean isLeaf(TreeNode root) { // д�����������ж��Ƿ�ΪҶ�ӣ�����
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return false;
    }
}