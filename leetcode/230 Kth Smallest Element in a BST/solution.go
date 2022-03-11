/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func kthSmallest(root *TreeNode, k int) int { // ���������ݹ� + ����BST�������ڵ����������
    leftCount, result := count(root.Left), 0
    
    if leftCount == k-1 { // ���ҳ��ڣ�����
        result = root.Val
    } else if leftCount > k-1 {
        result = kthSmallest(root.Left, k) // recursion������
    } else {
        result = kthSmallest(root.Right, k-leftCount-1) // recursion������
    }

    return result
}

func count(root *TreeNode) int { // д������������ڵ�����������
    if root == nil {
        return 0
    }
    return count(root.Left) + count(root.Right) + 1
}