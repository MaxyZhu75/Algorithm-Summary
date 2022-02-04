/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var newHead, newTail *ListNode = nil, nil // �����������ͷ���ָ���β���ָ�룡����
   
    carry :=0
    for (l1 != nil || l2 != nil) {
        l1Val := 0
        l2Val := 0
        if l1 != nil { // �϶̵�����ָ��Ӧ�ڵ���nullʱֹͣ��ÿ��ѭ�������жϣ���Ϊnull�����ʱֵΪ0������
            l1Val = l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            l2Val = l2.Val
            l2 = l2.Next
        }

        sum := (l1Val + l2Val + carry) % 10
        
        if newHead == nil {
            newHead = &ListNode{Val: sum} // ��������ӽ��ʱ��&�ṹ��{}���������ü�ֵ�Դ��빹�죡����
            newTail = newHead 
        } else {
            newTail.Next = &ListNode{Val: sum}
            newTail = newTail.Next
        }

        carry = (l1Val + l2Val + carry) / 10 // ���½�λ������
    }

    if carry != 0 {
        newTail.Next = &ListNode{Val: carry} // ���ĩβ��Ӻ��Ƿ��н�λ�����н�λ��Ҫ�����һ����㣡����
    }

    return newHead
}