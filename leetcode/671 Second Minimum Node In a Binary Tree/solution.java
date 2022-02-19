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
    int result = -1; // �����Ϊȫ�ֱ���������
    int rootVal;
    
    public int findSecondMinimumValue(TreeNode root) { // ��������DFS����������
        rootVal = root.val;
        treeDFS(root);
        return result;
    }

    public void treeDFS(TreeNode root) { // �ݹ�дDFS������
        if (root == null) { // ���ҳ��ڣ�����
            return;
        }

        int currentVal = root.val;
        if (result != -1 && currentVal > result) { // case1��result���޸Ĺ��ҵ�ǰ���ֵ����result����ֱ��return������
            return;
        }

        if (currentVal > rootVal) { // case2��resultδ�޸Ĺ��ҵ�ǰ���ֵ���ڸ��ڵ�ֵ����¼result������
            result = currentVal;
        }

        treeDFS(root.left); // recursion������
        treeDFS(root.right);
    }
}