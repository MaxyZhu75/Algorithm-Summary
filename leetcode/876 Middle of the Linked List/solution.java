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
    public ListNode middleNode(ListNode head) { // 快慢指针！！！
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { // 如果有两个中间结点，则返回第二个中间结点；条件判断具有先后顺序！！！
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}