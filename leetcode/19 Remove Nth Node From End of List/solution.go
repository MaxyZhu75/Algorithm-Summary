/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode { // 利用双指针帮助链表确定具体操作位置！！！
    p1, p2 := head, head
    for i:=0; i<n; i++ { // 联系实例可知，p2先走n步，再让p1与p2一起走，直至p2到达末尾，可以保证p1的指向落在原链表的倒数第n+1个节点！！！
        p2 = p2.Next
    }

    if p2 == nil { // 要点：在无哑节点的情况下，此处必须通过该方式判断需要删除的节点是否为头节点；若需要删除的是头结点，则直接返回head.next！！！
        return head.Next
    }

    for (p2.Next != nil) { // 由于p1的指向落在原链表的倒数第n+1个节点，此处帮助head执行删除倒数第n个节点的操作（该方式不能删除头结点，应预先对是否删除头结点进行判断和处理）！！！
        p2 = p2.Next
        p1 = p1.Next
    }
    
    p1.Next = p1.Next.Next
    
    return head
}