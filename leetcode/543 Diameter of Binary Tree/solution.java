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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) { // ���ұ߽磡����
            return 0;
        }
        int current = treeHeight(root.left) + treeHeight(root.right); // ��recursion������diameter����ó�������
        int diameter = triMax(current, diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)); // ����diameter��·����һ����ԭ���ĸ��ڵ㣬�˴���Ҫʹ��recursion���Ƚϲ�ȡ�����ֵ������
        return diameter;
    }

    public int treeHeight(TreeNode root) { // ���������ĸ߶ȣ�����
        if (root == null) {
            return 0;
        }
        int height = Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
        return height;
    }

    public int triMax(int a, int b, int c) { // ��д������ȡ���ֵ������
        if (a>=b && a>=c) {
            return a;
        } else if (b>=a && b>=c) {
            return b;
        } else {
            return c;
        }
    }
}