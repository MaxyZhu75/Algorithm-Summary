/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var result int // �����Ϊȫ�ֱ���������
var rootVal int

func findSecondMinimumValue(root *TreeNode) int { // ��������DFS����������
    result, rootVal = -1, root.Val
    treeDFS(root)
    return result
}

func treeDFS(root *TreeNode) { // �ݹ�дDFS������
    if root == nil { // ���ҳ��ڣ�����
        return
    }

    currentVal := root.Val
    if result != -1 && currentVal > result { // case1��result���޸Ĺ��ҵ�ǰ���ֵ����result����ֱ��return������
        return
    }

    if currentVal > rootVal { // case2��resultδ�޸Ĺ��ҵ�ǰ���ֵ���ڸ��ڵ�ֵ����¼result������
        result = currentVal
    }

    treeDFS(root.Left) // recursion������
    treeDFS(root.Right)
}