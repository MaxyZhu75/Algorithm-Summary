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

        ListNode current = hair; // 已处理部分的末尾！！！
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int value = current.next.val;
                while (current.next != null && current.next.val == value) {
                    current.next = current.next.next; // 更改current指向！！！
                }
            } else {
                current = current.next; // 更新current！！！
            }
        }

        return hair.next;
    }
}