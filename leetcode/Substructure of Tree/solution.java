/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) { // ����A��ÿ���ڵ㣬A������һ�ڵ����B���ܷ���true������
        return (A != null && B != null) && (recursion(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean recursion(TreeNode A, TreeNode B) { // ��AΪroot�����Ƿ����B�������A��ʼ��������
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recursion(A.left, B.left) && recursion(A.right, B.right);
    }
}