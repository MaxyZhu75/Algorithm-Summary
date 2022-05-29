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
    public boolean isValidBST(TreeNode root) { // �������ʣ�BST��������Ժ�õ�������һ�����������У���LeetCode��94�⣡����
        Deque<TreeNode> myStack = new ArrayDeque<>();
        double preVal = -Double.MAX_VALUE; // �ӵ㣺���ǵ����ڵ���ֵΪ���ֵ����32λ������Ϊ��ֵ������������
        TreeNode subtreeRoot = root;
        while (!myStack.isEmpty() || subtreeRoot != null) { // �ݹ�ⷨ������
            while (subtreeRoot != null) {
                myStack.addFirst(subtreeRoot);
                subtreeRoot = subtreeRoot.left;
            }
            TreeNode currentNode = myStack.removeFirst();
            if (currentNode.val <= preVal) return false;
            preVal = currentNode.val;
            subtreeRoot = currentNode.right; 
        } 
        return true;
    }
}