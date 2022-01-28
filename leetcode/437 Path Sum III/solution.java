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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        int startFromRoot = rootPathSum(root, targetSum);
        result = startFromRoot + pathSum(root.left, targetSum) + pathSum(root.right, targetSum); // recursion������
        return result;
    }

    public int rootPathSum(TreeNode root, int targetSum) { // ͳ�Ʊ����Ը��ڵ�Ϊ��㣬������·���͵�·��������
        if (root == null) {
            return 0;
        }
        int nextTarget = targetSum - root.val;
        int result = 0;
        if (nextTarget == 0) { 
            result++;
        }
        result += rootPathSum(root.left, nextTarget) + rootPathSum(root.right, nextTarget); // recursion������
        return result;
    }
}