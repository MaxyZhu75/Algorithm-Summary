/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result []int

func preorderTraversal(root *TreeNode) []int { // 方法二：递归（迭代方法见Java答案）！！！
    result = []int{} // 前序遍历：根左右！！！
    preorder(root)
    return result
}

func preorder(root *TreeNode) { // 要点：递归方法需要写辅助函数，在辅助函数中递归！！！
    if root == nil {
        return // 左右出口！！！
    }
    result = append(result, root.Val)
    preorder(root.Left)
    preorder(root.Right)
}