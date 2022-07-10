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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>(); // 栈能达到「反转链表」从低位开始计算的效果！！！
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.removeFirst(); // 细节：为空时值取0！！！
            int b = stack2.isEmpty() ? 0 : stack2.removeFirst();
            int sum = a + b + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}