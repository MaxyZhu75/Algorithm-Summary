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
    public int minCameraCover(TreeNode root) { // Ҫ�㣺dfs�ݹ� + ά������״̬������
        int[] array = dfs(root); // ״̬0����root�����������ͷʱ��������������Ҫ������ͷ��Ŀ������
        return array[1];         // ״̬1������root�Ƿ��������ͷ��������������Ҫ������ͷ��Ŀ������
    }    				         // ״̬2������root�Ƿ񱻼�ص�����������������Ҫ������ͷ��Ŀ������

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0}; // ��2����Ϊ��ֹ���������������������
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1; // ��root��������ͷ����left��rightһ��Ҳ�ᱻ��ص�����ʱֻ��Ҫ��֤left��right���Ե���������Ҳ�������Ǽ��ɣ�����
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1])); // root��������ͷ����״̬0�Ľ������root����������ͷ����ʱ������Ҫ��֤����root������������Ϊ��ʹroot�ᱻ��ص���left��right����һ������Ҫ��װ����ͷ������
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]); // ������֤�������������ǣ�Ҫôroot��������ͷ����״̬0�Ľ����Ҫôroot����������ͷ����ʱ���������ֱ�֤�Լ������Ǽ��ɣ��������ӽڵ�״̬1�Ľ����ӣ�����
        return array;
    }
}