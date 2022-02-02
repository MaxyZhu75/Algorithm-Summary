/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool { // 将链表分割为两部分，将后半部分反转与前半部分比较即可！！！
    if head == nil || head.Next == nil {
        return true
    }
    var slow, fast *ListNode = head, head.Next // 要点一：基于快慢指针思想来确定链表的中间位置；此处需要注意快慢指针的起点！！！
    for (fast != nil && fast.Next != nil) { // 注意不能拿fast.next.next作判断条件，会发生空指针异常！！！
        slow = slow.Next
        fast = fast.Next.Next
    }

    var secondHead, endFlag *ListNode = slow.Next, nil // 要点二：结合实例可知无论原链表含奇数个节点还是偶数个节点，分割链表时后半部分的头结点总为慢指针所指的下一个节点！！！

    if fast == nil { // 要点三：由fast指针位置判断原链表节点数的奇偶；endFlag是为了进一步确定分割的位置；奇数个节点时正中间的节点既不在前半部分，也不在后半部分！！！
        endFlag = slow
    } else {
        endFlag = slow.Next
    }

    cutLinkedList(head, endFlag)
    return isEqual(head, reverse(secondHead))
}

func cutLinkedList(head *ListNode, endFlag *ListNode) { // 自定义的分割方法，发现下一个是endFlag则跳出循环指向null！！！
    for (head.Next != endFlag) {
        head = head.Next
    }
    head.Next = nil
}

func reverse(head *ListNode) *ListNode { // 头插法，该方法的解释见LeetCode的206题！！！
    if head == nil || head.Next == nil {
        return head
    }
    var previous, current *ListNode = nil, head
    for (current != nil) {
        nextNode := current.Next
        current.Next = previous
        previous = current
        current = nextNode
    }
    return previous
}

func isEqual(firstHead *ListNode, secondHead *ListNode) bool { // 判断两个链表是否相等！！！
    for (firstHead != nil && secondHead != nil) {
        if (firstHead.Val != secondHead.Val) {
            return false
        } else {
			firstHead = firstHead.Next
			secondHead = secondHead.Next
		}
	}
    return true
}