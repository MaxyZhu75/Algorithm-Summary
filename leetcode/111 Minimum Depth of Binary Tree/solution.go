/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func minDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }

    result := 0

    if root.Left == nil || root.Right == nil {
        result = minDepth(root.Left) + minDepth(root.Right) + 1 // case1������Ϊ�գ�����Ҷ�ӣ������üӷ�ȡ��Ϊ�յ���һ�ߵ���С��ȣ��յ���һ�߽��Ϊ0�������߶�Ϊ�յ�Ҷ�ӽڵ㷵�ؽ����Ϊ1������
    } else {
        result = intMin(minDepth(root.Left), minDepth(root.Right)) + 1 // case2�����߶���Ϊ�գ���ֱ��ȡ���ߵݹ����Сֵ�ټ�1������
    }
    return result
}

func intMin(a int ,b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}