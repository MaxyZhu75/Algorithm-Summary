/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var valueRecord int // ע�⣬Go���Զ���ȫ�ֱ���ʱ��Ҫֱ�ӳ�ʼ����ֵ�����������

func convertBST(root *TreeNode) *TreeNode { // �����ڱ���˳���Ҹ���Ļ����Ͻ��в������ɣ�����
    valueRecord = 0
    inorderReverse(root)
    return root
}

func inorderReverse(root *TreeNode) { // �˴��൱�ڷ�ת����������������������ң�������
    if root == nil {
        return
    }
    inorderReverse(root.Right)
    valueRecord += root.Val
    root.Val = valueRecord
    inorderReverse(root.Left)
}