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
    public ListNode detectCycle(ListNode head) { // 快慢指针「找环的入口」；此处注重实现步骤，正确性证明见官方题解！！！
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) { // step1：先确定快慢指针在环内相遇！！！
                ListNode measure = head;
                while (measure != slow) { // step2：measure从链表头部与慢指针每次同时移动一步，直至最终在入口相遇！！！ 
                    measure = measure.next;
                    slow = slow.next;
                }
                return measure;
            }
        }
        return null;
    }
}