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
    public ListNode mergeKLists(ListNode[] lists) { // 分治合并！！！
        int k = lists.length;
        if (k == 0) return null;
        return merge(lists, 0, k-1);
    }

    private ListNode merge(ListNode[] lists, int low, int high) { // 分治后，返回合并！！！
        if (low == high) {
            return lists[low]; // 分治边界！！！
        }
        int mid = low + (high-low)/2;
        ListNode list1 = merge(lists, low, mid);
        ListNode list2 = merge(lists, mid+1, high);
        return mergeTwoLists(list1, list2);
    }
	
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) { // 递归实现两两合并；见LeetCode第21题解答！！！
        if (list1 == null) return list2;
        if (list2 == null) return list1;        
        ListNode current = new ListNode();
        if (list1.val < list2.val) {
            current = list1;
            current.next = mergeTwoLists(list1.next, list2);
        } else {
            current = list2;
            current.next = mergeTwoLists(list1, list2.next);          
        }
        return current;
    }
}