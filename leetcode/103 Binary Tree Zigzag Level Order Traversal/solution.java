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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) { // LeetCode��102����������չ�⣡����
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> bfsQueue = new ArrayDeque<>();
        bfsQueue.addLast(root);

        boolean direction = true;
        while (!bfsQueue.isEmpty()) {
            int nextLevelNodes = bfsQueue.size();
            Deque<Integer> group = new LinkedList<>(); // �������ڴ˴���Ҫ����Deque�����ݲ�ͬ���������׻��β��ӽڵ㣡����
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
            result.add(new ArrayList<Integer>(group)); // ��Dequeת��Ϊ��Ŀ����Ҫ���ص�List���ͣ�����
            direction = !direction; // ��һ��ת�䷽�򣡣���
        }
        return result;
    }
}