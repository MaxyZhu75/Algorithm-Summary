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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) { // ��Ŀ����������Ϊ�գ�����
            return false;
        }
        boolean result = false;
        boolean startFromRoot = isSubtreeFromRoot(root, subRoot);
        result = startFromRoot || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); // recursion������
        return result;
    }

    public boolean isSubtreeFromRoot(TreeNode root, TreeNode subRoot) { // ����ӵ�ǰ���ڵ����������Ƿ�������������
        if (root == null && subRoot == null) { // case1����Ϊ�գ�����
            return true;
        }

        if (root == null || subRoot == null) { // case2������һ��Ϊ�գ�����
            return false;
        }

        boolean result = false;
        if (root.val != subRoot.val) { // case3������Ϊ�գ��Ƚ�ֵ�Ĵ�С������
            return false;
        } else {
            result = isSubtreeFromRoot(root.left, subRoot.left) && isSubtreeFromRoot(root.right, subRoot.right); // recursion������
        }
        return result;
    }
}