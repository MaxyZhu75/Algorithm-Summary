/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func rotateRight(head *ListNode, k int) *ListNode { // 「先闭合为环，再找到尾部断开」！！！
    if head == nil || head.Next == nil {
        return head
    }

    n := 1 // 统计链表长度！！！
    var node *ListNode= head
    for node.Next != nil {
        n++
        node = node.Next
    }

    k = k % n // 移动n的整数倍时相当于未移动！！！
    if k == 0 {
        return head
    }

    node.Next = head // 操作一：闭合为环；使尾节点指针指向头节点！！！
    steps := n-k
    for steps > 0 { // 操作二：移动「n-k」步即可到达新链表的尾节点！！！
        node = node.Next
        steps--
    }
    head = node.Next
    node.Next = nil
    return head
}