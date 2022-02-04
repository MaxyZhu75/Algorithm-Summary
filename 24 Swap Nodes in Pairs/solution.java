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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
		
		// ����ָ��
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode nextNode = p2.next;
		// �޸�ָ��
        p2.next = p1;
        ListNode newHead = p2; // ע��Ӧԭ����ͷ����ѱ��������ڶ�λ�ã�Ӧ���½�newHeadָ�벢��Ϊ���ؽ��������
        p1.next = swapPairs(nextNode);

        return newHead;
    }
}