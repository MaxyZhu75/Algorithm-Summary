/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB; // 双指针思想，把对方走过的路走一遍！！！
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next; // 三元运算符！！！
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}