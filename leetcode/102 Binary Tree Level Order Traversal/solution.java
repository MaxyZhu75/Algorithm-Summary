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
    public List<List<Integer>> levelOrder(TreeNode root) { // BFS层序遍历！！！
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.addLast(root);
        while (!bfsQueue.isEmpty()) {
            int nextLevelNodes = bfsQueue.size();
            List<Integer> group = new ArrayList<>(); // 同一深度的节点需要放入同一列表后再添加入result！！！
            while (nextLevelNodes-- > 0) {
                TreeNode node = bfsQueue.pollFirst();
                group.add(node.val);
                if (node.left != null) {
                    bfsQueue.addLast(node.left);
                }
                if (node.right != null) {
                    bfsQueue.addLast(node.right);
                }
            }
            result.add(group);
        }
        return result;
    }
}