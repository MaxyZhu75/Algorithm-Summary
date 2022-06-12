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
    public boolean hasCycle(ListNode head) { //「Floyd 判圈算法」（快慢指针）！！！
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head; // 细节：由于使用while循环判断条件先行，此处快慢指针起点不应在同一位置！！！
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