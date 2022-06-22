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
    public ListNode rotateRight(ListNode head, int k) { // 「先闭合为环，再找到尾部断开」！！！
        if (head == null || head.next == null) return head;
        int n = 1; // 统计链表长度！！！
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }
        k = k % n; // 移动n的整数倍时相当于未移动！！！
        if (k == 0) return head;
        node.next = head; // 操作一：闭合为环；使尾节点指针指向头节点！！！
		int steps = n-k;
        while (steps-- > 0) { // 操作二：移动「n-k」步即可到达新链表的尾节点！！！
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}