/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result []int

func preorderTraversal(root *TreeNode) []int { // ���������ݹ飨����������Java�𰸣�������
    result = []int{} // ǰ������������ң�����
    preorder(root)
    return result
}

func preorder(root *TreeNode) { // Ҫ�㣺�ݹ鷽����Ҫд�����������ڸ��������еݹ飡����
    if root == nil {
        return // ���ҳ��ڣ�����
    }
    result = append(result, root.Val)
    preorder(root.Left)
    preorder(root.Right)
}