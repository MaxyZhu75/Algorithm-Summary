/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sumOfLeftLeaves(root *TreeNode) int {
    if root == nil { // 左右出口！！！
        return 0
    }

    result := 0
    if isLeaf(root.Left) {
        result = root.Left.Val + sumOfLeftLeaves(root.Right) // case1：左子结点为叶子！！！
    } else {
        result = sumOfLeftLeaves(root.Left) + sumOfLeftLeaves(root.Right) // case2：左子节点不为叶子！！！
    }
    
    return result
}

func isLeaf(root *TreeNode) bool { // 写辅助方法来判断是否为叶子！！！
    if root == nil {
        return false
    }

    if root.Left == nil && root.Right == nil {
        return true
    }

    return false
}