/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) { // ����ָ�롸�һ�����ڡ����˴�ע��ʵ�ֲ��裬��ȷ��֤�����ٷ���⣡����
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { // step1����ȷ������ָ���ڻ�������������
                ListNode measure = head;
                while (measure != slow) { // step2��measure������ͷ������ָ��ÿ��ͬʱ�ƶ�һ����ֱ��������������������� 
                    measure = measure.next;
                    slow = slow.next;
                }
                return measure;
            }
        }
        return null;
    }
}