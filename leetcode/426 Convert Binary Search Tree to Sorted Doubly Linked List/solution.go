/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 * }
 */

var head *Node // ����ͷ�ڵ㣡����
var tail *Node // ����β��㣡����

func treeToDoublyList(root *Node) *Node { // ��������ݹ���������
    if root == nil {
        return nil
    }
    head, tail = nil, nil
    inoerderTraversal(root)
    head.Left = tail // ѭ��������ͷ�ڵ��β�ڵ����ϣ�����
    tail.Right = head
    return head
}

func inoerderTraversal(root *Node) { // �������������ң�����
    if root == nil {
        return
    }
    
    inoerderTraversal(root.Left)

    if tail == nil {
        head = root // �״ν���ݹ�ʱ��¼rootΪͷ�ڵ㣡����
    } else {
        root.Left = tail // ˫������˫���ָ�����ӣ�����
        tail.Right = root
    }
    tail = root // ÿ��ݹ����β�ڵ㣡����

    inoerderTraversal(root.Right)
}