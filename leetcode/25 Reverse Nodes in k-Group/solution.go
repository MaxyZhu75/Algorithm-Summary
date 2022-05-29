/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseKGroup(head *ListNode, k int) *ListNode { // ��Ҫ����������ɣ�����
    hair := &ListNode{Val: -1, Next: head} // ��������hair�ڵ�������������������
    var tail, preTail, nextHead *ListNode
    preTail = hair
    
    for head != nil {
        tail = preTail // ��tail�ƻ�preTail�����鿴ʣ�ಿ�ֳ����Ƿ���ڵ���k������
        for i:=0; i<k; i++ {
            tail = tail.Next
            if tail == nil {
                return hair.Next
            }
        }

        nextHead = tail.Next // �Ͽ���ǰ��������һ���֣������з�ת������
        tail.Next = nil
        nodes := reverseList(head, tail)
        head, tail = nodes[0], nodes[1] // ��ת����µ�ǰhead��tail������

        preTail.Next = head // ���ò������½ӻ�ԭ������ͷβ���д�����������preTail��headλ�ã�����
        tail.Next = nextHead
        preTail = tail
        head = tail.Next
    }

    return hair.Next
}

func reverseList(head *ListNode, tail *ListNode) []*ListNode { // ��LeetCode��206�⣡��
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