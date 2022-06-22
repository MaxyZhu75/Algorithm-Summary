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
    int[] preorder;
	int preorderIndex = 0;
    Map<Integer, Integer> inorderRecord = new HashMap<>();
    
	public TreeNode buildTree(int[] preorder, int[] inorder) { // 递归解决；前序「根左右」中序「左根右」！！！
        this.preorder = preorder;
		for (int i=0; i<inorder.length; i++) { // 存储每个元素在中序遍历数组中的索引！！！
            inorderRecord.put(inorder[i], i);
        }

        return arrayToTree(0, preorder.length-1);
    }

    private TreeNode arrayToTree(int left, int right) {
        if (left > right) return null; // 出口：左边界大于右边界！！！
		
        int rootValue = preorder[preorderIndex]; // Step1：前序遍历确定「根」！！！
		preorderIndex++;
        TreeNode root = new TreeNode(rootValue);

		int inorderIndex = inorderRecord.get(rootValue); // Step2：中序遍历递归连接根的「左右子节点」！！！
        root.left = arrayToTree(left, inorderIndex-1);
        root.right = arrayToTree(inorderIndex+1, right);
        
		return root; // 每次返回当前根节点！！！
    }
}