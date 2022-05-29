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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { // LeetCode第102题层序遍历拓展题！！！
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.addLast(root);

        boolean direction = true;
        while (!bfsQueue.isEmpty()) {
            int nextLevelNodes = bfsQueue.size();
            Deque<Integer> group = new LinkedList<>(); // 区别在于此处需要利用Deque，根据不同方向往队首或队尾添加节点！！！
            while (nextLevelNodes-- > 0) {
                TreeNode node = bfsQueue.pollFirst();
                if (direction == true) {
                    group.addLast(node.val);
                } else {
                    group.addFirst(node.val);
                }
                if (node.left != null) {
                    bfsQueue.addLast(node.left);
                }
                if (node.right != null) {
                    bfsQueue.addLast(node.right);
                }
            }
            result.add(new ArrayList<Integer>(group)); // 将Deque转化为题目所需要返回的List类型！！！
            direction = !direction; // 下一层转变方向！！！
        }
        return result;
    }
}