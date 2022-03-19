/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rangeSumBST(root *TreeNode, low int, high int) int { // ���������ݹ�BST������
    if root == nil {
        return 0
    }
    if (root.Val > high) {
        return rangeSumBST(root.Left, low, high)
    } else if (root.Val < low) {
        return rangeSumBST(root.Right, low, high)
    } else {
        return root.Val + rangeSumBST(root.Left, low, high) + rangeSumBST(root.Right, low, high)
    }
}