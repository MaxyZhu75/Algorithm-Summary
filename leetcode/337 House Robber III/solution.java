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
    public int rob(TreeNode root) { // ע����Ⲣ���Ǽ򵥵Ĳ��������ͣ�����
        int[] result = valueMax(root);
        return Math.max(result[0], result[1]);
    }

    public int[] valueMax(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftNode = new int[2]; // С͵��ÿ���ڵ�������ѡ�񣬴�ٻ򲻴�٣�������������ֵ���Ƕ�Ҫ�������ȥ�Ƚϣ�����
        int[] rightNode = new int[2]; // �������飬array[0]�洢�Ըýڵ�Ϊ���Ҹýڵ㲻��������ܵõ�������ֵ����array[1]�洢�Ըýڵ�Ϊ���Ҹýڵ㱻������ܵõ�������ֵ������
        int[] containsRoot = new int[2];

        leftNode = valueMax(root.left); // �����ӽڵ��ȵݹ鶨�壬��ʹ�ã�����
        rightNode = valueMax(root.right);
        containsRoot[0] = Math.max(leftNode[0], leftNode[1]) + Math.max(rightNode[0], rightNode[1]); // case1��root������٣���ȡ�����ӽڵ���Եݹ��������ֵ��Ӽ��ɣ�����
        containsRoot[1] = leftNode[0] + rightNode[0] + root.val; // case2��root����٣���ȡroot��ֵ�Լ������ӽڵ㲻�����ʱ���ܵõ�������ֵ��ӣ�����

        return containsRoot;
    }
}