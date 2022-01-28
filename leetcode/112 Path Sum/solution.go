/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func hasPathSum(root *TreeNode, targetSum int) bool {
    if root == nil { // 左右边界！！！
        return  false
    }

    nextTarget := targetSum - root.Val
    if nextTarget == 0 && root.Left == nil && root.Right == nil { // 两个条件：路径和为0且为叶子节点！！！
        return true
    }

    return hasPathSum(root.Left, nextTarget) || hasPathSum(root.Right, nextTarget) // recursion！！！
}