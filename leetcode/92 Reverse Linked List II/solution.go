/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseBetween(head *ListNode, left int, right int) *ListNode {
    hair := &ListNode{Val: -1}
    hair.Next = head
    previous := hair
    for i:=0; i<left-1; i++ {
        previous = previous.Next
    }
    current := previous.Next
    for i := 0; i < right-left; i++ { // ³Æ×÷¡¸´©ÕëÒýÏß¡¹£¡£¡£¡
        nextNode := current.Next
        current.Next = nextNode.Next
        nextNode.Next = previous.Next
        previous.Next = nextNode
    }
    return hair.Next
}