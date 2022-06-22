/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func flatten(root *TreeNode)  { // ��������Ѱ��ǰ���ڵ㣨�����ռ临�Ӷȣ�������
    current := root
    for current != nil {
        if current.Left != nil { // �����������Ϊ�գ����������������ұߵĽڵ���Ϊǰ���ڵ㣡����
            next := current.Left // �洢ԭʼ�������ĸ�������
            predecessor := next
            for predecessor.Right != nil {
                predecessor = predecessor.Right
            }
            predecessor.Right = current.Right // ��ǰ���ڵ���ָ�����ӵ�ԭʼ�������ĸ�������
            current.Left, current.Right = nil, next // �������������Ƶ���ǰ�ڵ��ұߣ���������Ϊ�գ�����
        }
        current = current.Right // ���ƴ���������������
    }
}