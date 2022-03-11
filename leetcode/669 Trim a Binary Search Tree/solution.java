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
    public TreeNode trimBST(TreeNode root, int low, int high) { // �ݹ飬ע��BST���ʣ�����
        if (root == null) return null; // ���ҳ��ڣ�����
        if (root.val < low) { // case1��root��lowС������root����������С��root����root������������ȫ��������Ȼ������޼�������������
            return trimBST(root.right, low, high);
        } else if (root.val > high) { // case2��root��highС������root���������Դ���root����root������������ȫ��������Ȼ������޼�����������
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high); // case3��root�ڷ�Χ�ڣ���root����BST�У�������������Ӧͬ������BST���ʣ���˼����������޼�������
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}