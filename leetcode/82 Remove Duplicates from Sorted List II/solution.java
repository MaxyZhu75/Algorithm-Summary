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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode hair = new ListNode(0, head);

        ListNode current = hair; // �Ѵ����ֵ�ĩβ������
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int value = current.next.val;
                while (current.next != null && current.next.val == value) {
                    current.next = current.next.next; // ����currentָ�򣡣���
                }
            } else {
                current = current.next; // ����current������
            }
        }

        return hair.next;
    }
}