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
    public List<Double> averageOfLevels(TreeNode root) { // 计算每层平均值自然联想到层序遍历，则可以使用常规BFS！！！
        List<Double> result = new ArrayList<>();
        
        Queue<TreeNode> bfsQueue = new LinkedList<>(); // BFS需要队列实现！！！
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) { // BFS写法总结可参见LeetCode1091题答案！！！
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