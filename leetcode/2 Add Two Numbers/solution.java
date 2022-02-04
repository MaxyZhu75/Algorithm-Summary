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
        ListNode newhead = null; // 创建新链表的头结点指针和尾结点指针！！！
        ListNode newTail = null;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val; // 较短的链表指针应在等于null时停止，每次循环进行判断，若为null则相加时值为0！！！
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = (l1Val + l2Val + carry) % 10;
            if (newhead == null) {
                newhead = new ListNode(sum); // 新链表添加结点时，看构造函数new！！！
                newTail = newhead;
            } else {
                newTail.next = new ListNode(sum);
                newTail = newTail.next;
            }

            carry =  (l1Val + l2Val + carry) / 10; // 更新进位！！！

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) { 
            newTail.next = new ListNode(carry); // 检查末尾相加后是否有进位；若有进位需要再添加一个结点！！！
        }
		
        return newhead;
    }
}