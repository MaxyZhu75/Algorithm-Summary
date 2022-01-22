/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode { // 递归方法！！！
    if head == nil || head.Next == nil { // 出口：链表为空或已到达链表末尾！！！
        return head
    }
    // 递！！！
	var nextNode *ListNode = head.Next
    reversed := reverseList(nextNode)
    // 归！！！
	nextNode.Next = head  // 操作一：使当前节点head变成已经反转的新链表的末尾；也就是将之前新链表的末尾节点head.Next指向head！！！
    head.Next = nil // 操作二：再将已经反转的新链表末尾暂时定义为空！！！
    return reversed
}