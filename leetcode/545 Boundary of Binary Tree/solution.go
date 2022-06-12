/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func boundaryOfBinaryTree(root *TreeNode) []int { // 由题目描述的定义，划分成三个递归子问题：左边界、叶子节点和右边界！！！
    result := []int{root.Val}
    leftBoundary(root.Left, &result) // 手动加入root后按顺序调用递归！！！
    leaves(root.Left, &result)
    leaves(root.Right, &result)
    rightBoundary(root.Right, &result)
    return result
}

func leftBoundary(root *TreeNode, result *[]int) { // 左边界递归！！！
    if root == nil || (root.Left == nil && root.Right == nil) {
        return
    }
    *result = append(*result, root.Val) // 要点：在递归前添加，则左边界按由上至下顺序遍历！！！
    if root.Left != nil {
        leftBoundary(root.Left, &*result)
    } else {
        leftBoundary(root.Right, &*result)
    }
}

func rightBoundary(root *TreeNode, result *[]int) { // 右边界递归！！！
    if root == nil || (root.Left == nil && root.Right == nil) {
        return
    }
    if root.Right != nil {
        rightBoundary(root.Right, &*result)
    } else {
        rightBoundary(root.Left, &*result)
    }
    *result = append(*result, root.Val) // 要点：在递归后添加，则右边界按从下到上逆序遍历！！！
}

func leaves(root *TreeNode, result *[]int) { // 叶子节点递归！！！
    if root == nil {
        return
    }
    if root.Right == nil && root.Left == nil {
        *result = append(*result, root.Val)
        return
    }
    leaves(root.Left, &*result) // 非叶子节点则继续往下下潜，且先左后右！！！
    leaves(root.Right, &*result)
}