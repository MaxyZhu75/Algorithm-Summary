/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func hasCycle(head *ListNode) bool { //��Floyd ��Ȧ�㷨��������ָ�룩������
    if head == nil || head.Next == nil {
        return false
    }
    slow, fast := head, head.Next // ϸ�ڣ�����ʹ��whileѭ���ж��������У��˴�����ָ����㲻Ӧ��ͬһλ�ã�����
    for slow != fast {
        if fast == nil || fast.Next == nil {
            return false
        }
        slow = slow.Next
        fast = fast.Next.Next
    }
    return true
}