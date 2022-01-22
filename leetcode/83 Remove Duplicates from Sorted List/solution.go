/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil || head.Next == nil { // 左右边界！！！
        return head
    }
    
    head.Next = deleteDuplicates(head.Next) // 先进入递归，选择链表指向的节点！！！

    if head.Next.Val == head.Val {
        return head.Next // 值相同的节点则选择更靠后的！！！
    } else {
        return head
    }
}