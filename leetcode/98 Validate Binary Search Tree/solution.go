/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func isValidBST(root *TreeNode) bool { // 递归解决！！！
    return recursion(root, math.MinInt64, math.MaxInt64) // 坑点：考虑单个节点且值为最大值，则32位整数作为初值并不够！！！
}

func recursion(root *TreeNode, lower, upper int) bool { // 判断以root为根的子树中，是否所有节点的值满足介于(lower, upper)之间！！！
    if root == nil {
        return true
    }
    if root.Val <= lower || root.Val >= upper {
        return false
    }
    return recursion(root.Left, lower, root.Val) && recursion(root.Right, root.Val, upper)
}