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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode previous = hair;
        for (int i=0; i<left-1; i++) {
            previous = previous.next;
        }
        ListNode current = previous.next;
        for (int i=left; i<right; i++) { // ³Æ×÷¡¸´©ÕëÒýÏß¡¹£¡£¡£¡
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = previous.next;
            previous.next = nextNode;
        }
        return hair.next;
    }
}