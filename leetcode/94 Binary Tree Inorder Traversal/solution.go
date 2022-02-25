/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result []int

func inorderTraversal(root *TreeNode) []int { // ���������ݹ飨����������Java�𰸣�������
    result = []int{} // �������������ң�����
    inorder(root)
    return result
}

func inorder(root *TreeNode) { // Ҫ�㣺�ݹ鷽����Ҫд�����������ڸ��������еݹ飡����
    if root == nil {
        return
    }
    inorder(root.Left)
    result = append(result, root.Val)
    inorder(root.Right)
}