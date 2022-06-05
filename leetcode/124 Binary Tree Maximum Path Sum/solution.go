/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func maxPathSum(root *TreeNode) int { // 递归！！！
    result := math.MinInt32
    recursion(root, &result)
    return result;
}

func recursion(root *TreeNode, result *int) int { // 注意：题目所需的result仅在递归中修改，而不是返回值；函数返回的是root到叶子的最大路径和！！！
    if root == nil {
        return 0
    }
    left := max(recursion(root.Left, result), 0) // 分别获取左右子节点到叶子的最大路径和！！！
    right := max(recursion(root.Right, result), 0)
    current := left + right + root.Val
    *result = max(*result, current)
    return root.Val + max(left, right) // 返回root到叶子的最大路径和！！！
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}