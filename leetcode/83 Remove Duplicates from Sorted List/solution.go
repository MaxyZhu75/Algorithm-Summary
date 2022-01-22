/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil || head.Next == nil { // ���ұ߽磡����
        return head
    }
    
    head.Next = deleteDuplicates(head.Next) // �Ƚ���ݹ飬ѡ������ָ��Ľڵ㣡����

    if head.Next.Val == head.Val {
        return head.Next // ֵ��ͬ�Ľڵ���ѡ�������ģ�����
    } else {
        return head
    }
}