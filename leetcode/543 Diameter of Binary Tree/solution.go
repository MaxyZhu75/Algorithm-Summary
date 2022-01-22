/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func diameterOfBinaryTree(root *TreeNode) int {
    if root == nil {  // 左右边界！！！
        return 0
    }
    current := treeHeight(root.Left) + treeHeight(root.Right)  // 该recursion由树的diameter定义得出！！！
    diameter := triMax(current, diameterOfBinaryTree(root.Left), diameterOfBinaryTree(root.Right)) // 由于diameter的路径不一定过原本的根节点，此处需要使用recursion，比较并取出最大值！！！
    return diameter
}

func treeHeight(root *TreeNode) int { // 经典求树的高度！！！
    if root == nil {
        return 0
    }
    height := twoMax(treeHeight(root.Left), treeHeight(root.Right)) + 1
    return height
}

func twoMax(a, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}

func triMax(a int, b int, c int) int {  // 手写三个数取最大值！！！
    if a>=b && a>=c {
        return a
    } else if b >=a && b>=c {
        return b
    } else {
        return c
    }
}