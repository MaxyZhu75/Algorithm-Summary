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
    public ListNode reverseList(ListNode head) { // 递归方法！！！
        if ( head == null || head.next == null ) { // 出口：链表为空或已到达链表末尾！！！
            return head;
        }
        // 递！！！
        ListNode nextNode = head.next;
        ListNode reversed = reverseList(nextNode); // 由右向左构造新链表，reversed代表已经反转的新链表！！！
        // 归！！！
        nextNode.next = head; // 操作一：使当前节点head变成已经反转的新链表的末尾；也就是将之前新链表的末尾节点head.next指向head！！！
        head.next = null; // 操作二：再将已经反转的新链表末尾暂时定义为空！！！
        return reversed;
    }
}