/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseKGroup(head *ListNode, k int) *ListNode { // 按要求对链表处理即可！！！
    hair := &ListNode{Val: -1, Next: head} // 必须设置hair节点来帮助返回链表！！！
    var tail, preTail, nextHead *ListNode
    preTail = hair
    
    for head != nil {
        tail = preTail // 将tail移回preTail帮助查看剩余部分长度是否大于等于k！！！
        for i:=0; i<k; i++ {
            tail = tail.Next
            if tail == nil {
                return hair.Next
            }
        }

        nextHead = tail.Next // 断开当前部分与下一部分，并进行反转！！！
        tail.Next = nil
        nodes := reverseList(head, tail)
        head, tail = nodes[0], nodes[1] // 反转后更新当前head与tail！！！

        preTail.Next = head // 将该部分重新接回原链表（对头尾进行处理），并更新preTail与head位置！！！
        tail.Next = nextHead
        preTail = tail
        head = tail.Next
    }

    return hair.Next
}

func reverseList(head *ListNode, tail *ListNode) []*ListNode { // 见LeetCode第206题！！
    var previous, current *ListNode = nil, head
    for current != nil {
        nextNode := current.Next
        current.Next = previous
        previous = current
        current = nextNode
    }
    result := []*ListNode{tail, head}
    return result
}