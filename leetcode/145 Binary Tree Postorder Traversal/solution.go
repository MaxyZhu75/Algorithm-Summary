/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result []int

func postorderTraversal(root *TreeNode) []int { // 方法二：递归（迭代方法见Java答案）！！！
    result = []int{} // 后序遍历：左右根！！！
    postorder(root)
    return result
}

func postorder(root *TreeNode) { // 要点：递归方法需要写辅助函数，在辅助函数中递归！！！
    if root == nil {
        return // 左右出口！！！
    }
    postorder(root.Left)
    postorder(root.Right)
    result = append(result, root.Val)
}