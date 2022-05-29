/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reorderList(head *ListNode)  { // 寻找链表中点 + 链表反转 + 合并链表！！！
    mid := middleNode(head)
    list1, list2 := head, mid.Next
    mid.Next = nil
    list2 = reverseList(list2)
    mergeLists(list1, list2)
}

func middleNode(head *ListNode) *ListNode { // 见LeetCode第876题！！！
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }
    return slow
}

func reverseList(head *ListNode) *ListNode { // 见LeetCode第206题！！！
    var previous, current *ListNode = nil, head
    for current != nil {
        nextNode := current.Next
        current.Next = previous
        previous = current
        current = nextNode
    }
    return previous
}

func mergeLists(list1 *ListNode, list2 *ListNode) { // 此处仅需按规则更换指针指向进行合并；而LeetCode第22题是合并有序列表，需要用到递归！！！
    var next1, next2 *ListNode 
    for list1 != nil && list2 != nil {
        next1, next2 = list1.Next, list2.Next
        
        list1.Next = list2
        list1 = next1

        list2.Next = list1
        list2 = next2
    }
}