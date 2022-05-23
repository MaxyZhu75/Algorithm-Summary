/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func pairSum(head *ListNode) int { // ����ָ�� + ��ת��������
    slow, fast := head, head.Next
    for fast.Next != nil && fast.Next.Next != nil { // fast��������ĩβ��slow�պ�ָ��ǰһ�벿�������ĩβ�ڵ㣡����
        slow = slow.Next
        fast = fast.Next.Next
    }

    head2 := slow.Next
    slow.Next = nil

    var previous, current *ListNode = nil, head2 // ��206�ⷴת��������
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