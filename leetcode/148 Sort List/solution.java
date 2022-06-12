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
    public ListNode sortList(ListNode head) { // 自底向上归并排序 + 迭代 ；常数空间复杂度！！！
        if (head == null) return head;
        int n = 0;
        ListNode node = head;
        while (node != null) { // 求链表原本长度 n ！！！
            n++;
            node = node.next;
        }

        ListNode hair = new ListNode(0, head);
        for (int length = 1; length < n; length*=2) { // length表示每次需要排序的「子链表长度」；注意每次将length的值「加倍」！！！
            ListNode previous = hair, current = hair.next;
            while (current != null) { // 将链表拆分成若干个长度为length的子链表（最后一个子链表的长度可以小于length），按照每两个子链表一组进行合并！！！
                ListNode head1 = current;
                for (int i=1; i<length && current.next != null; i++) { // 第一个子链表！！！
                    current = current.next;
                }
                
				ListNode head2 = current.next; // 对指针进行处理！！！
                current.next = null;
                current = head2;
                
				for (int i=1; i<length && current != null && current.next != null; i++) { // 第二个子链表！！！
                    current = current.next;
                }

                ListNode nextNode = null; // 处理指针指向，为合并下一组子链表做准备，nextNode标记下次的起始处！！！
                if (current != null) {
                    nextNode = current.next;
                    current.next = null;
                }

                ListNode merged = merge(head1, head2); // 合并当前两个子链表得到「有序链表」！！！
                previous.next = merged;
                while (previous.next != null) {
                    previous = previous.next; // previous移至「合并链表末尾」！！！
                }
                current = nextNode; // current移至nextNode！！！
            }
        }
        return hair.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) { // LeetCode第21题迭代解法！！！
        ListNode hair = new ListNode(0);
        ListNode previous = hair, l1 = head1, l2 = head2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                previous.next = l1;
                l1 = l1.next;
            } else {
                previous.next = l2;
                l2 = l2.next;
            }
            previous = previous.next;
        }
        previous.next = (l1 == null) ? l2 : l1;
        return hair.next;
    }
}