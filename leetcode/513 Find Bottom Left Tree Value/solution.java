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
    public int findBottomLeftValue(TreeNode root) { // BFS���������ע����ײ�����߽ڵ㣬��һ�������ӽڵ㣬ֻҪ����߼��ɣ�����
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        
        TreeNode currentNode = null;
        while (!bfsQueue.isEmpty()) { // ÿ�����ʱ���Һ��������һ�����ӵĽڵ������������ײ�����ߣ�����
            currentNode = bfsQueue.poll();
            if (currentNode.right != null) bfsQueue.add(currentNode.right);
            if (currentNode.left != null) bfsQueue.add(currentNode.left);
        }
        return currentNode.val;
    }
}