/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func boundaryOfBinaryTree(root *TreeNode) []int { // ����Ŀ�����Ķ��壬���ֳ������ݹ������⣺��߽硢Ҷ�ӽڵ���ұ߽磡����
    result := []int{root.Val}
    leftBoundary(root.Left, &result) // �ֶ�����root��˳����õݹ飡����
    leaves(root.Left, &result)
    leaves(root.Right, &result)
    rightBoundary(root.Right, &result)
    return result
}

func leftBoundary(root *TreeNode, result *[]int) { // ��߽�ݹ飡����
    if root == nil || (root.Left == nil && root.Right == nil) {
        return
    }
    *result = append(*result, root.Val) // Ҫ�㣺�ڵݹ�ǰ��ӣ�����߽簴��������˳�����������
    if root.Left != nil {
        leftBoundary(root.Left, &*result)
    } else {
        leftBoundary(root.Right, &*result)
    }
}

func rightBoundary(root *TreeNode, result *[]int) { // �ұ߽�ݹ飡����
    if root == nil || (root.Left == nil && root.Right == nil) {
        return
    }
    if root.Right != nil {
        rightBoundary(root.Right, &*result)
    } else {
        rightBoundary(root.Left, &*result)
    }
    *result = append(*result, root.Val) // Ҫ�㣺�ڵݹ����ӣ����ұ߽簴���µ����������������
}

func leaves(root *TreeNode, result *[]int) { // Ҷ�ӽڵ�ݹ飡����
    if root == nil {
        return
    }
    if root.Right == nil && root.Left == nil {
        *result = append(*result, root.Val)
        return
    }
    leaves(root.Left, &*result) // ��Ҷ�ӽڵ������������Ǳ����������ң�����
    leaves(root.Right, &*result)
}