/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func goodNodes(root *TreeNode) int {
    return 1 + goodNode(root.Left, root.Val) + goodNode(root.Right, root.Val)
}

func goodNode(root *TreeNode, maxVal int) int { // �ڵݹ麯���д���·���е����ֵ������
    if root == nil {
        return 0
    }

    current := 0
    if root.Val >= maxVal {
        current = 1
        maxVal = root.Val
    }
    return current + goodNode(root.Left, maxVal) + goodNode(root.Right, maxVal)
}