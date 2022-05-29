/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 
func middleNode(head *ListNode) *ListNode { // ����ָ�룡����
    slow, fast := head, head
    for fast != nil && fast.Next != nil { // ����������м��㣬�򷵻صڶ����м��㣻�����жϾ����Ⱥ�˳�򣡣���
        slow = slow.Next
        fast = fast.Next.Next
    }
    return slow
}