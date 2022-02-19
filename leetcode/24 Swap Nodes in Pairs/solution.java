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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
		
	// 定义指针！！！
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode nextNode = p2.next;
	// 按特定顺序修改指针指向！！！
        p2.next = p1;
        ListNode newHead = p2; // 注意应原来的头结点已被交换到第二位置，应该新建newHead指针并作为返回结果！！！
        p1.next = swapPairs(nextNode); // recursion！！！

        return newHead;
    }
}
