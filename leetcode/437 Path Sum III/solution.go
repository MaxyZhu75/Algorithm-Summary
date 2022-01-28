/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathSum(root *TreeNode, targetSum int) int {
    if root == nil {
        return 0
    }
    result, startFromRoot := 0, 0
    startFromRoot = rootPathSum(root, targetSum)
    result = startFromRoot + pathSum(root.Left, targetSum) + pathSum(root.Right, targetSum) // recursion！！！
    return result
}

func rootPathSum(root *TreeNode, targetSum int) int { // 统计必须以根节点为起点，且满足路径和的路径！！！
    if root == nil {
        return 0
    }
    result, nextTargetSum := 0, targetSum-root.Val
    if (nextTargetSum == 0) {
        result++
    }
    result += rootPathSum(root.Left, nextTargetSum) + rootPathSum(root.Right, nextTargetSum) // recursion！！！
    return result
}