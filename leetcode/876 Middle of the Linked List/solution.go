/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 
func middleNode(head *ListNode) *ListNode { // 快慢指针！！！
    slow, fast := head, head
    for fast != nil && fast.Next != nil { // 如果有两个中间结点，则返回第二个中间结点；条件判断具有先后顺序！！！
        slow = slow.Next
        fast = fast.Next.Next
    }
    return slow
}