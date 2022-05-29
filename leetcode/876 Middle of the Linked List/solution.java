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
    public ListNode middleNode(ListNode head) { // ����ָ�룡����
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { // ����������м��㣬�򷵻صڶ����м��㣻�����жϾ����Ⱥ�˳�򣡣���
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}