/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
    if root == nil { // ���ұ߽磡����
        return 0
    }
    if root.Left == nil && root.Right == nil {
        return 1
    }
    depth := max(maxDepth(root.Left), maxDepth(root.Right)) + 1 // recursion������
    return depth
}

func max(a int, b int) int { // Go������math.Math()��float64���ͣ�����
    if a > b {
        return a
    } else {
        return b
    }
}