/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var valueRecord int // 注意，Go语言定义全局变量时不要直接初始化赋值，会出错！！！

func convertBST(root *TreeNode) *TreeNode { // 该题在遍历顺序：右根左的基础上进行操作即可！！！
    valueRecord = 0
    inorderReverse(root)
    return root
}

func inorderReverse(root *TreeNode) { // 此处相当于反转中序遍历（中序遍历：左根右）！！！
    if root == nil {
        return
    }
    inorderReverse(root.Right)
    valueRecord += root.Val
    root.Val = valueRecord
    inorderReverse(root.Left)
}