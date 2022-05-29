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
    public void reorderList(ListNode head) { // 寻找链表中点 + 链表反转 + 合并链表！！！
        ListNode mid = middleNode(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;
        list2 = reverseList(list2);
        mergeLists(list1, list2);
    }

    public ListNode middleNode(ListNode head) { // 见LeetCode第876题！！！
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) { // 见LeetCode第206题！！！
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    public void mergeLists(ListNode list1, ListNode list2) { // 此处仅需按规则更换指针指向进行合并；而LeetCode第22题是合并有序列表，需要用到递归！！！
        ListNode next1;
        ListNode next2;
        while (list1 != null && list2 != null) {
            next1 = list1.next;
            next2 = list2.next;

            list1.next = list2;
            list1 = next1;

            list2.next = list1;
            list2 = next2;
        }
    }
}