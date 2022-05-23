/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func pairSum(head *ListNode) int { // 快慢指针 + 反转链表！！！
    slow, fast := head, head.Next
    for fast.Next != nil && fast.Next.Next != nil { // fast到达链表末尾，slow刚好指向前一半部分链表的末尾节点！！！
        slow = slow.Next
        fast = fast.Next.Next
    }

    head2 := slow.Next
    slow.Next = nil

    var previous, current *ListNode = nil, head2 // 见206题反转链表！！！
    for (current != nil) {
        var nextNode *ListNode = current.Next
        current.Next = previous
        previous = current
        current = nextNode
    }

    result := math.MinInt32
    for head != nil {
        result = max(result, head.Val + previous.Val)
        head, previous = head.Next, previous.Next
    }
    return result
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}