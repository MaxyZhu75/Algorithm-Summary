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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2; // 左右边界！！！
        if (list2 == null) return list1;        
        ListNode current = new ListNode();
        if (list1.val < list2.val) {
            current = list1;
            current.next = mergeTwoLists(list1.next, list2); // recursion！！！
        } else {
            current = list2;
            current.next = mergeTwoLists(list1, list2.next);          
        }
        return current;
    }
}
