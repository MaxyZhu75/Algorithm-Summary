/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result []int

func postorderTraversal(root *TreeNode) []int { // ���������ݹ飨����������Java�𰸣�������
    result = []int{} // ������������Ҹ�������
    postorder(root)
    return result
}

func postorder(root *TreeNode) { // Ҫ�㣺�ݹ鷽����Ҫд�����������ڸ��������еݹ飡����
    if root == nil {
        return // ���ҳ��ڣ�����
    }
    postorder(root.Left)
    postorder(root.Right)
    result = append(result, root.Val)
}