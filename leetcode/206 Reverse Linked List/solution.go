/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
    var previous, current *ListNode = nil, head // ���䷽����ͷ�巨������previous, current, nextNode�����������������
    for (current != nil) {
        var nextNode *ListNode = current.Next // nextNode���´δ�����Ľڵ㣬�ֲ�������ʱ�洢������
        current.Next = previous // ListNode.Next�ڵȺ���߱�����ʱ������ȷ��ָ��ָ���൱����Ⱥ��ұ����ӣ��˴��ұ�Ϊ������ǰ�ѷ�ת�Ĳ��֣�������
        previous = current // ��ʱcurrent����Ѿ���ת������ǰ��������������ӣ������previous������
        current = nextNode // �������´�ѭ���Ĵ�����ڵ㣡����
    }
    return previous // ���ص����Ѵ��������previous������
}