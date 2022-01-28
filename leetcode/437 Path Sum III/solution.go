/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathSum(root *TreeNode, targetSum int) int {
    if root == nil {
        return 0
    }
    result, startFromRoot := 0, 0
    startFromRoot = rootPathSum(root, targetSum)
    result = startFromRoot + pathSum(root.Left, targetSum) + pathSum(root.Right, targetSum) // recursion������
    return result
}

func rootPathSum(root *TreeNode, targetSum int) int { // ͳ�Ʊ����Ը��ڵ�Ϊ��㣬������·���͵�·��������
    if root == nil {
        return 0
    }
    result, nextTargetSum := 0, targetSum-root.Val
    if (nextTargetSum == 0) {
        result++
    }
    result += rootPathSum(root.Left, nextTargetSum) + rootPathSum(root.Right, nextTargetSum) // recursion������
    return result
}