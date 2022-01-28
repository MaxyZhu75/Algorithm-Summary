/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func hasPathSum(root *TreeNode, targetSum int) bool {
    if root == nil { // ���ұ߽磡����
        return  false
    }

    nextTarget := targetSum - root.Val
    if nextTarget == 0 && root.Left == nil && root.Right == nil { // ����������·����Ϊ0��ΪҶ�ӽڵ㣡����
        return true
    }

    return hasPathSum(root.Left, nextTarget) || hasPathSum(root.Right, nextTarget) // recursion������
}