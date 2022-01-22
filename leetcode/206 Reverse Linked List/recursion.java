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
    public ListNode reverseList(ListNode head) { // �ݹ鷽��������
        if ( head == null || head.next == null ) { // ���ڣ�����Ϊ�ջ��ѵ�������ĩβ������
            return head;
        }
        // �ݣ�����
        ListNode nextNode = head.next;
        ListNode reversed = reverseList(nextNode); // ����������������reversed�����Ѿ���ת������������
        // �飡����
        nextNode.next = head; // ����һ��ʹ��ǰ�ڵ�head����Ѿ���ת���������ĩβ��Ҳ���ǽ�֮ǰ�������ĩβ�ڵ�head.nextָ��head������
        head.next = null; // ���������ٽ��Ѿ���ת��������ĩβ��ʱ����Ϊ�գ�����
        return reversed;
    }
}