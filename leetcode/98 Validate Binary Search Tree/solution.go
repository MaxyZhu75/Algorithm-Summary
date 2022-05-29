/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func isValidBST(root *TreeNode) bool { // �ݹ���������
    return recursion(root, math.MinInt64, math.MaxInt64) // �ӵ㣺���ǵ����ڵ���ֵΪ���ֵ����32λ������Ϊ��ֵ������������
}

func recursion(root *TreeNode, lower, upper int) bool { // �ж���rootΪ���������У��Ƿ����нڵ��ֵ�������(lower, upper)֮�䣡����
    if root == nil {
        return true
    }
    if root.Val <= lower || root.Val >= upper {
        return false
    }
    return recursion(root.Left, lower, root.Val) && recursion(root.Right, root.Val, upper)
}