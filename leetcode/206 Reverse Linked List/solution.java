/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null; // ���䷽����ͷ�巨������previous, current, nextNode�����������������
        ListNode current = head;
        while (current != null){
            ListNode nextNode = current.next; // nextNode���´δ�����Ľڵ㣬�ֲ�������ʱ�洢������
            current.next = previous; // ListNode.next�ڵȺ���߱�����ʱ������ȷ��ָ��ָ���൱����Ⱥ��ұ����ӣ��˴��ұ�Ϊ������ǰ�ѷ�ת�Ĳ��֣�������
            previous = current; // ��ʱcurrent����Ѿ���ת������ǰ��������������ӣ������previous������
            current = nextNode; // �������´�ѭ���Ĵ�����ڵ㣡����
        }
        return previous; // ���ص����Ѵ��������previous������
    }
}