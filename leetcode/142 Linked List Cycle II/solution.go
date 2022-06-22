/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func detectCycle(head *ListNode) *ListNode { // ����ָ�롸�һ�����ڡ����˴�ע��ʵ�ֲ��裬��ȷ��֤�����ٷ���⣡����
    if head == nil {
        return nil
    }
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
        if slow == fast { // step1����ȷ������ָ���ڻ�������������
            var measure *ListNode = head
            for measure != slow { // step2��measure������ͷ������ָ��ÿ��ͬʱ�ƶ�һ����ֱ��������������������� 
                measure = measure.Next
                slow = slow.Next
            }
            return measure
        }
    }
    return nil
}