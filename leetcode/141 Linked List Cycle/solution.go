/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func hasCycle(head *ListNode) bool { //「Floyd 判圈算法」（快慢指针）！！！
    if head == nil || head.Next == nil {
        return false
    }
    slow, fast := head, head.Next // 细节：由于使用while循环判断条件先行，此处快慢指针起点不应在同一位置！！！
    for slow != fast {
        if fast == nil || fast.Next == nil {
            return false
        }
        slow = slow.Next
        fast = fast.Next.Next
    }
    return true
}