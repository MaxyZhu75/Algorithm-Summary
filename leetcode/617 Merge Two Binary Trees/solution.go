/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
    if root1 == nil && root2 == nil { // case1���߽磬��Ϊ�գ�����
        return nil
    }
    if root1 == nil { // case2������һ��Ϊ�գ�����
        return root2
    }
    if root2 == nil {
        return root1
    }

    root2.Val += root1.Val // case3���Բ�Ϊ�գ�����
    root2.Left = mergeTrees(root1.Left, root2.Left) // recursion������
    root2.Right = mergeTrees(root1.Right, root2.Right)
    return root2
}