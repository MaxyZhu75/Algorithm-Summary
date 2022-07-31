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
    Map<String, Integer> count; // �洢�������л���������ִ���������
    List<TreeNode> result; // �������ε����������������

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.count = new HashMap();
        this.result = new ArrayList();
        recursion(root);
        return result;
    }

    public String recursion(TreeNode root) {
        if (root == null) return "#";
        String serial = root.val + "," + recursion(root.left) + "," + recursion(root.right); // ���л�ƴ�ӣ�����
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            result.add(root);
		}
        return serial;
    }
}