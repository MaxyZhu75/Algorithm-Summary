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
    public int longestUnivaluePath(TreeNode root) { // ��LeetCode543��ݹ�ṹ���ƣ�����
        if (root == null) {
            return 0;
        }
		
		// ˼·������Ҫ��ıؾ���ǰroot�ڵ���·������root���������·����������ɣ�����
        int passRoot = longestOneSideFromRoot(root.left, root.val) + longestOneSideFromRoot(root.right, root.val);
		
		// �·����һ������ԭ���ĸ��ڵ㣬����Ҫ�������µݹ飡����
        int result = triMax(passRoot, longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        
        return result;
    }

    public int longestOneSideFromRoot(TreeNode current, int rootVal) { // ע��·�����ֲܷ棬���㵥���·��������dfsȡ�������
        if (current == null || current.val != rootVal) { // Ҫ��һ���Ѹ��ڵ��ֵ����ø�������������������������࣡����
            return 0;
        }

        int leftSide = 0;
        int rightSide = 0;
        if (current.left != null) {
            leftSide = longestOneSideFromRoot(current.left, current.val);
        }
        if (current.right != null) {
            rightSide = longestOneSideFromRoot(current.right, current.val);
        }

        int path = Math.max(leftSide, rightSide) + 1; // Ҫ�������ǰ�ڵ��븸�ڵ�ֵ��ȳ��ȼ�1������·�����ֲܷ棬�˴�������������߷ֿ��ݹ�����ȡ���ߵ�����뵱ǰ�ڵ����ӣ�����
		
        return path;
    }

    public int triMax(int a, int b, int c) {
        if (a>=b && a>=c) {
            return a;
        } else if (b>=a && b>=c) {
            return b;
        } else {
            return c;
        }
    }

}