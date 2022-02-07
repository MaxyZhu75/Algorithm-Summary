/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }

	// ����ָ�룡����
    p1, p2 := head, head.Next
    nextNode := p2.Next
	// ���ض�˳���޸�ָ��ָ�򣡣���
    p2.Next = p1
    newHead := p2 // ע��Ӧԭ����ͷ����ѱ��������ڶ�λ�ã�Ӧ���½�newHeadָ�벢��Ϊ���ؽ��������
    p1.Next = swapPairs(nextNode) // recursion������

    return newHead
}