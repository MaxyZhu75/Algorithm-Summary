/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func detectCycle(head *ListNode) *ListNode { // 快慢指针「找环的入口」；此处注重实现步骤，正确性证明见官方题解！！！
    if head == nil {
        return nil
    }
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
        if slow == fast { // step1：先确定快慢指针在环内相遇！！！
            var measure *ListNode = head
            for measure != slow { // step2：measure从链表头部与慢指针每次同时移动一步，直至最终在入口相遇！！！ 
                measure = measure.Next
                slow = slow.Next
            }
            return measure
        }
    }
    return nil
}