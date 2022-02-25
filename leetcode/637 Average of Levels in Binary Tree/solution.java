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
    public List<Double> averageOfLevels(TreeNode root) { // ����ÿ��ƽ��ֵ��Ȼ���뵽��������������ʹ�ó���BFS������
        List<Double> result = new ArrayList<>();
        
        Queue<TreeNode> bfsQueue = new LinkedList<>(); // BFS��Ҫ����ʵ�֣�����
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) { // BFSд���ܽ�ɲμ�LeetCode1091��𰸣�����
            int nodeNum = bfsQueue.size();
            double sum = 0;
            for (int i=0; i<nodeNum; i++) {
                TreeNode currentNode = bfsQueue.poll();
                double currentVal = (double)currentNode.val;
                sum += currentVal;
                if (currentNode.left != null) bfsQueue.add(currentNode.left);
                if (currentNode.right != null) bfsQueue.add(currentNode.right);
            }

            result.add(sum/nodeNum);
        }
        return result;
    }
}