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
    
	public TreeNode buildTree(int[] preorder, int[] inorder) { // �ݹ�����ǰ�򡸸����ҡ���������ҡ�������
        this.preorder = preorder;
		for (int i=0; i<inorder.length; i++) { // �洢ÿ��Ԫ����������������е�����������
            inorderRecord.put(inorder[i], i);
        }

        return arrayToTree(0, preorder.length-1);
    }

    private TreeNode arrayToTree(int left, int right) {
        if (left > right) return null; // ���ڣ���߽�����ұ߽磡����
		
        int rootValue = preorder[preorderIndex]; // Step1��ǰ�����ȷ��������������
		preorderIndex++;
        TreeNode root = new TreeNode(rootValue);

		int inorderIndex = inorderRecord.get(rootValue); // Step2����������ݹ����Ӹ��ġ������ӽڵ㡹������
        root.left = arrayToTree(left, inorderIndex-1);
        root.right = arrayToTree(inorderIndex+1, right);
        
		return root; // ÿ�η��ص�ǰ���ڵ㣡����
    }
}