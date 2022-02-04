/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func minDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }

    result := 0

    if root.Left == nil || root.Right == nil {
        result = minDepth(root.Left) + minDepth(root.Right) + 1 // case1：单边为空（不是叶子），则用加法取不为空的那一边的最小深度（空的那一边结果为0）；两边都为空的叶子节点返回结果必为1！！！
    } else {
        result = intMin(minDepth(root.Left), minDepth(root.Right)) + 1 // case2：两边都不为空，则直接取两边递归的最小值再加1！！！
    }
    return result
}

func intMin(a int ,b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}