/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    hair := &ListNode{Val: -1, Next: head}
    current := hair // �Ѵ����ֵ�ĩβ������
    for current.Next != nil && current.Next.Next != nil {
        if current.Next.Val != current.Next.Next.Val {
            current = current.Next // ����current������
        } else {
            value := current.Next.Val
            for current.Next != nil && current.Next.Val == value {
                current.Next = current.Next.Next // ����currentָ�򣡣���
            }
        }
    }
    return hair.Next
}