/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result int // 结果设为全局变量！！！
var rootVal int

func findSecondMinimumValue(root *TreeNode) int { // 二叉树的DFS遍历！！！
    result, rootVal = -1, root.Val
    treeDFS(root)
    return result
}

func treeDFS(root *TreeNode) { // 递归写DFS！！！
    if root == nil { // 左右出口！！！
        return
    }

    currentVal := root.Val
    if result != -1 && currentVal > result { // case1：result已修改过且当前结点值大于result，则直接return！！！
        return
    }

    if currentVal > rootVal { // case2：result未修改过且当前结点值大于根节点值，记录result！！！
        result = currentVal
    }

    treeDFS(root.Left) // recursion！！！
    treeDFS(root.Right)
}