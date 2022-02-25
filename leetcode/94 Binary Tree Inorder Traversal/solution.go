/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result []int

func inorderTraversal(root *TreeNode) []int { // 方法二：递归（迭代方法见Java答案）！！！
    result = []int{} // 中序遍历：左根右！！！
    inorder(root)
    return result
}

func inorder(root *TreeNode) { // 要点：递归方法需要写辅助函数，在辅助函数中递归！！！
    if root == nil {
        return
    }
    inorder(root.Left)
    result = append(result, root.Val)
    inorder(root.Right)
}