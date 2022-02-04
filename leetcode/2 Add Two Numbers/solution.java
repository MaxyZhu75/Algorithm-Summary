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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newhead = null; // �����������ͷ���ָ���β���ָ�룡����
        ListNode newTail = null;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val; // �϶̵�����ָ��Ӧ�ڵ���nullʱֹͣ��ÿ��ѭ�������жϣ���Ϊnull�����ʱֵΪ0������
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = (l1Val + l2Val + carry) % 10;
            if (newhead == null) {
                newhead = new ListNode(sum); // ��������ӽ��ʱ�������캯��new������
                newTail = newhead;
            } else {
                newTail.next = new ListNode(sum);
                newTail = newTail.next;
            }

            carry =  (l1Val + l2Val + carry) / 10; // ���½�λ������

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) { 
            newTail.next = new ListNode(carry); // ���ĩβ��Ӻ��Ƿ��н�λ�����н�λ��Ҫ�����һ����㣡����
        }
		
        return newhead;
    }
}