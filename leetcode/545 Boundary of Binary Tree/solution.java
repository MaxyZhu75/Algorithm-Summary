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

    public List<Integer> boundaryOfBinaryTree(TreeNode root) { // 由题目描述的定义，划分成三个递归子问题：左边界、叶子节点和右边界！！！
        result.add(root.val);
        leftBoundary(root.left); // 手动加入root后按顺序调用递归！！！
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return result;
    }

	public void leftBoundary(TreeNode root) { // 左边界递归！！！
		if (root == null || (root.left == null && root.right == null)) return;
		result.add(root.val); // 要点：在递归前添加，则左边界按由上至下顺序遍历！！！
		if (root.left != null) {
            leftBoundary(root.left);
        } else {
            leftBoundary(root.right);
        }
	}

	public void rightBoundary(TreeNode root) { // 右边界递归！！！
		if (root == null || (root.right == null && root.left == null)) return;
		if (root.right != null) {
            rightBoundary(root.right);
        } else {
            rightBoundary(root.left);
        }
		result.add(root.val); // 要点：在递归后添加，则右边界按从下到上逆序遍历！！！
	}

	public void leaves(TreeNode root) { // 叶子节点递归！！！
		if (root == null) return;
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		leaves(root.left); // 非叶子节点则继续往下下潜，且先左后右！！！
		leaves(root.right);
	}
}