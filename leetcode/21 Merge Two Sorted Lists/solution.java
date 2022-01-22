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
        ListNode mergedList = new ListNode(); // 定义新的合并后的链表！！！
        if (list1.val < list2.val) { // 注意ListNode可以视作指针指的首地址内容！！！
            mergedList = list1; // 根据不同情况初始化！！！
            mergedList.next = mergeTwoLists(list1.next, list2); // recursion！！！
        } else {
            mergedList = list2;
            mergedList.next = mergeTwoLists(list1, list2.next);          
        }
        return mergedList;
    }
}