/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
    if root == nil { // 左右边界！！！
        return true
    }
    if abs(treeHeight(root.Left) - treeHeight(root.Right)) > 1 { // 由balance的定义写出！！！
        return false
    }
    balance := isBalanced(root.Left) && isBalanced(root.Right) // 自顶向下recursion；该题存在更优解为自底向上！！！
    return balance
}

func treeHeight(root *TreeNode) int { // 计算树的高度！！！
    if root == nil {
        return 0
    }
    height := max(treeHeight(root.Left), treeHeight(root.Right)) + 1
    return height
}

func max(a int, b int) int { // Go语言中手动写int型最大值函数，调用math.Max需要输入float64！！！
    if (a > b) {
        return a
    } else {
        return b
    }
}

func abs (a int) int { // Go语言中手动写int型绝对值函数，调用math.Abs需要输入float64！！！
    if a < 0 {
        return -1 * a
    } else {
        return a
    }
}