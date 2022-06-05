/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func maxPathSum(root *TreeNode) int { // �ݹ飡����
    result := math.MinInt32
    recursion(root, &result)
    return result;
}

func recursion(root *TreeNode, result *int) int { // ע�⣺��Ŀ�����result���ڵݹ����޸ģ������Ƿ���ֵ���������ص���root��Ҷ�ӵ����·���ͣ�����
    if root == nil {
        return 0
    }
    left := max(recursion(root.Left, result), 0) // �ֱ��ȡ�����ӽڵ㵽Ҷ�ӵ����·���ͣ�����
    right := max(recursion(root.Right, result), 0)
    current := left + right + root.Val
    *result = max(*result, current)
    return root.Val + max(left, right) // ����root��Ҷ�ӵ����·���ͣ�����
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}