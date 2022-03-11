/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func kthSmallest(root *TreeNode, k int) int { // 方法二：递归 + 计算BST左子树节点个数！！！
    leftCount, result := count(root.Left), 0
    
    if leftCount == k-1 { // 左右出口！！！
        result = root.Val
    } else if leftCount > k-1 {
        result = kthSmallest(root.Left, k) // recursion！！！
    } else {
        result = kthSmallest(root.Right, k-leftCount-1) // recursion！！！
    }

    return result
}

func count(root *TreeNode) int { // 写辅助方法计算节点数量！！！
    if root == nil {
        return 0
    }
    return count(root.Left) + count(root.Right) + 1
}