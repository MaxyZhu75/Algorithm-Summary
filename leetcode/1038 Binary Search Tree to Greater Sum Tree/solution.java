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
    int valueRecord;

    public TreeNode bstToGst(TreeNode root) { // �����ڱ���˳���Ҹ���Ļ����Ͻ��в������ɣ�����
        valueRecord = 0;
        inorderReverse(root);
        return root;
    }

    public void inorderReverse(TreeNode root) { // �˴��൱�ڷ�ת����������������������ң�������
        if (root == null) return;
        inorderReverse(root.right);
        valueRecord += root.val;
        root.val = valueRecord;
        inorderReverse(root.left);
    }
}