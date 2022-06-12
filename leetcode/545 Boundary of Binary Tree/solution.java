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
    List<Integer> result = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) { // ����Ŀ�����Ķ��壬���ֳ������ݹ������⣺��߽硢Ҷ�ӽڵ���ұ߽磡����
        result.add(root.val);
        leftBoundary(root.left); // �ֶ�����root��˳����õݹ飡����
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return result;
    }

	public void leftBoundary(TreeNode root) { // ��߽�ݹ飡����
		if (root == null || (root.left == null && root.right == null)) return;
		result.add(root.val); // Ҫ�㣺�ڵݹ�ǰ��ӣ�����߽簴��������˳�����������
		if (root.left != null) {
            leftBoundary(root.left);
        } else {
            leftBoundary(root.right);
        }
	}

	public void rightBoundary(TreeNode root) { // �ұ߽�ݹ飡����
		if (root == null || (root.right == null && root.left == null)) return;
		if (root.right != null) {
            rightBoundary(root.right);
        } else {
            rightBoundary(root.left);
        }
		result.add(root.val); // Ҫ�㣺�ڵݹ����ӣ����ұ߽簴���µ����������������
	}

	public void leaves(TreeNode root) { // Ҷ�ӽڵ�ݹ飡����
		if (root == null) return;
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		leaves(root.left); // ��Ҷ�ӽڵ������������Ǳ����������ң�����
		leaves(root.right);
	}
}