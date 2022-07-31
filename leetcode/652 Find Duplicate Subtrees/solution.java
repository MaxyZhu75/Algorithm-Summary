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
    Map<String, Integer> count; // 存储树的序列化，及其出现次数！！！
    List<TreeNode> result; // 出现两次的树则加入结果！！！

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.count = new HashMap();
        this.result = new ArrayList();
        recursion(root);
        return result;
    }

    public String recursion(TreeNode root) {
        if (root == null) return "#";
        String serial = root.val + "," + recursion(root.left) + "," + recursion(root.right); // 序列化拼接！！！
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            result.add(root);
		}
        return serial;
    }
}