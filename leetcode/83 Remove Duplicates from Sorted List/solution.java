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
        if (head == null || head.next == null) { // ���ұ߽磡����
            return head;
        }
        
        head.next = deleteDuplicates(head.next); // �Ƚ���ݹ飬ѡ������ָ��Ľڵ㣡����
        
        if (head.next.val == head.val) {
            return head.next; // ֵ��ͬ�Ľڵ���ѡ�������ģ�����
        } else {
            return head;
        }
    }
}