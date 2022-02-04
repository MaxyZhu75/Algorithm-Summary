/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sumOfLeftLeaves(root *TreeNode) int {
    if root == nil { // ���ҳ��ڣ�����
        return 0
    }

    result := 0
    if isLeaf(root.Left) {
        result = root.Left.Val + sumOfLeftLeaves(root.Right) // case1�����ӽ��ΪҶ�ӣ�����
    } else {
        result = sumOfLeftLeaves(root.Left) + sumOfLeftLeaves(root.Right) // case2�����ӽڵ㲻ΪҶ�ӣ�����
    }
    
    return result
}

func isLeaf(root *TreeNode) bool { // д�����������ж��Ƿ�ΪҶ�ӣ�����
    if root == nil {
        return false
    }

    if root.Left == nil && root.Right == nil {
        return true
    }

    return false
}