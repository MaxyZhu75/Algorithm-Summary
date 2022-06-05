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
    public TreeNode deleteNode(TreeNode root, int key) { // ����ݹ飡����
        if (root == null) return null;
        
		if (root.val > key) {
            root.left = deleteNode(root.left, key); // Ŀ�����������У����ú���Ҫֱ��return������
            return root;
        }
        
		if (root.val < key) {
            root.right = deleteNode(root.right, key); // Ŀ�����������У����ú���Ҫֱ��return������
            return root;
        }
        
		if (root.val == key) {
            if (root.left == null && root.right == null) { // case1��Ŀ��ΪҶ�ӽڵ㣬û����������ʱ����ֱ�ӽ���ɾ���������ؿգ�����
                return null;
            }
            if (root.right == null) { // case2��Ŀ��ֻ��������û������������ʱ���Խ�������������Ϊ�µ������������������ӽڵ㣡����
                return root.left;
            }
            if (root.left == null) { // case3��Ŀ��ֻ��������û������������ʱ���Խ�������������Ϊ�µ������������������ӽڵ㣡����
                return root.right;
            }
            TreeNode successor = root.right; // case4��Ŀ������������������
            while (successor.left != null) {
                successor = successor.left; // ��̽ڵ㣺��root�����С�ڵ㣬�������������е�����ڵ㣡����
            }
            root.right = deleteNode(root.right, successor.val); // ����һ����successor��Ŀ�����������ɾ����ע��successorû�����ӽڵ㣬�ݹ�ɾ��ʱ��Ȼ�����ٴβ�������������
            successor.right = root.right; // ����������successorֱ�����Ŀ�꣡����
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}