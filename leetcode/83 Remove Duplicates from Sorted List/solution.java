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
        if (head == null || head.next == null) { // 左右边界！！！
            return head;
        }
        
        head.next = deleteDuplicates(head.next); // 先进入递归，选择链表指向的节点！！！
        
        if (head.next.val == head.val) {
            return head.next; // 值相同的节点则选择更靠后的！！！
        } else {
            return head;
        }
    }
}