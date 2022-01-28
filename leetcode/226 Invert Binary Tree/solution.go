/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
    if root == nil { // 左右出口！！！
        return nil
    }
    temp := root.Left
    root.Left = invertTree(root.Right) // 传入另一边的子节点进行recursion即可！！！
    root.Right = invertTree(temp)
    return root
}