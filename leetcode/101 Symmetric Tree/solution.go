/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isSymmetric(root *TreeNode) bool { // ������ڵ㲻Ϊ�գ�����
    return isEqual(root.Left, root.Right)
}

func isEqual(root1 *TreeNode, root2 *TreeNode) bool { // �ݹ鷽��������
    if root1 == nil && root2 == nil {
        return true
    }

    if root1 == nil || root2 == nil {
        return false
    }

    if root1.Val != root2.Val {
        return false
    }

    result := isEqual(root1.Left, root2.Right) && isEqual(root1.Right, root2.Left)
    return result
}