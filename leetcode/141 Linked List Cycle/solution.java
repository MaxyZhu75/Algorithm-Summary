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
    public boolean hasCycle(ListNode head) { //��Floyd ��Ȧ�㷨��������ָ�룩������
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head; // ϸ�ڣ�����ʹ��whileѭ���ж��������У��˴�����ָ����㲻Ӧ��ͬһλ�ã�����
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}