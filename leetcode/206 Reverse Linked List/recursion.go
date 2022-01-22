/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode { // �ݹ鷽��������
    if head == nil || head.Next == nil { // ���ڣ�����Ϊ�ջ��ѵ�������ĩβ������
        return head
    }
    // �ݣ�����
	var nextNode *ListNode = head.Next
    reversed := reverseList(nextNode)
    // �飡����
	nextNode.Next = head  // ����һ��ʹ��ǰ�ڵ�head����Ѿ���ת���������ĩβ��Ҳ���ǽ�֮ǰ�������ĩβ�ڵ�head.Nextָ��head������
    head.Next = nil // ���������ٽ��Ѿ���ת��������ĩβ��ʱ����Ϊ�գ�����
    return reversed
}