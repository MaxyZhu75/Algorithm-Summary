/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var newHead, newTail *ListNode = nil, nil // 创建新链表的头结点指针和尾结点指针！！！
   
    carry :=0
    for (l1 != nil || l2 != nil) {
        l1Val := 0
        l2Val := 0
        if l1 != nil { // 较短的链表指针应在等于null时停止，每次循环进行判断，若为null则相加时值为0！！！
            l1Val = l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            l2Val = l2.Val
            l2 = l2.Next
        }

        sum := (l1Val + l2Val + carry) % 10
        
        if newHead == nil {
            newHead = &ListNode{Val: sum} // 新链表添加结点时，&结构体{}，参数可用键值对传入构造！！！
            newTail = newHead 
        } else {
            newTail.Next = &ListNode{Val: sum}
            newTail = newTail.Next
        }

        carry = (l1Val + l2Val + carry) / 10 // 更新进位！！！
    }

    if carry != 0 {
        newTail.Next = &ListNode{Val: carry} // 检查末尾相加后是否有进位；若有进位需要再添加一个结点！！！
    }

    return newHead
}