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
    public List<Integer> rightSideView(TreeNode root) { // BFS从左向右遍历，将每层最右节点加入即可！！！
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.addLast(root);

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size-- > 0) {
                TreeNode currentNode = bfsQueue.pollFirst();
                if (size == 0) {
                    result.add(currentNode.val); // 加入该深度的最右节点！！！
                }
                if (currentNode.left != null) bfsQueue.addLast(currentNode.left);
                if (currentNode.right != null) bfsQueue.addLast(currentNode.right);
            }
        }
        return result;
    }
}