/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func rotateRight(head *ListNode, k int) *ListNode { // ���ȱպ�Ϊ�������ҵ�β���Ͽ���������
    if head == nil || head.Next == nil {
        return head
    }

    n := 1 // ͳ�������ȣ�����
    var node *ListNode= head
    for node.Next != nil {
        n++
        node = node.Next
    }

    k = k % n // �ƶ�n��������ʱ�൱��δ�ƶ�������
    if k == 0 {
        return head
    }

    node.Next = head // ����һ���պ�Ϊ����ʹβ�ڵ�ָ��ָ��ͷ�ڵ㣡����
    steps := n-k
    for steps > 0 { // ���������ƶ���n-k�������ɵ����������β�ڵ㣡����
        node = node.Next
        steps--
    }
    head = node.Next
    node.Next = nil
    return head
}