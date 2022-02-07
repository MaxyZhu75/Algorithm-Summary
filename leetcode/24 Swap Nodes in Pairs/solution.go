/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }

	// 定义指针！！！
    p1, p2 := head, head.Next
    nextNode := p2.Next
	// 按特定顺序修改指针指向！！！
    p2.Next = p1
    newHead := p2 // 注意应原来的头结点已被交换到第二位置，应该新建newHead指针并作为返回结果！！！
    p1.Next = swapPairs(nextNode) // recursion！！！

    return newHead
}