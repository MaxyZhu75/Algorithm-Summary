/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool { // ������ָ�Ϊ�����֣�����벿�ַ�ת��ǰ�벿�ֱȽϼ��ɣ�����
    if head == nil || head.Next == nil {
        return true
    }
    var slow, fast *ListNode = head, head.Next // Ҫ��һ�����ڿ���ָ��˼����ȷ��������м�λ�ã��˴���Ҫע�����ָ�����㣡����
    for (fast != nil && fast.Next != nil) { // ע�ⲻ����fast.next.next���ж��������ᷢ����ָ���쳣������
        slow = slow.Next
        fast = fast.Next.Next
    }

    var secondHead, endFlag *ListNode = slow.Next, nil // Ҫ��������ʵ����֪����ԭ�����������ڵ㻹��ż�����ڵ㣬�ָ�����ʱ��벿�ֵ�ͷ�����Ϊ��ָ����ָ����һ���ڵ㣡����

    if fast == nil { // Ҫ��������fastָ��λ���ж�ԭ����ڵ�������ż��endFlag��Ϊ�˽�һ��ȷ���ָ��λ�ã��������ڵ�ʱ���м�Ľڵ�Ȳ���ǰ�벿�֣�Ҳ���ں�벿�֣�����
        endFlag = slow
    } else {
        endFlag = slow.Next
    }

    cutLinkedList(head, endFlag)
    return isEqual(head, reverse(secondHead))
}

func cutLinkedList(head *ListNode, endFlag *ListNode) { // �Զ���ķָ����������һ����endFlag������ѭ��ָ��null������
    for (head.Next != endFlag) {
        head = head.Next
    }
    head.Next = nil
}

func reverse(head *ListNode) *ListNode { // ͷ�巨���÷����Ľ��ͼ�LeetCode��206�⣡����
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

func isEqual(firstHead *ListNode, secondHead *ListNode) bool { // �ж����������Ƿ���ȣ�����
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