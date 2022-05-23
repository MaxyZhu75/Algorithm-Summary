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
    public int pairSum(ListNode head) { // ����ָ�� + ��ת��������
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) { // fast��������ĩβ��slow�պ�ָ��ǰһ�벿�������ĩβ�ڵ㣡����
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode previous = null; // ��206�ⷴת��������
        ListNode current = head2;
        while (current != null){
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        int result = Integer.MIN_VALUE;
        while (head != null) {
            result = Math.max(result, head.val + previous.val);
            head = head.next;
            previous = previous.next;
        }
        return result;
    }
}