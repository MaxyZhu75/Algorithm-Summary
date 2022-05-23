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
    public int pairSum(ListNode head) { // 快慢指针 + 反转链表！！！
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) { // fast到达链表末尾，slow刚好指向前一半部分链表的末尾节点！！！
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode previous = null; // 见206题反转链表！！！
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