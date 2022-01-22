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
        if (list1 == null) return list2; // ���ұ߽磡����
        if (list2 == null) return list1;        
        ListNode mergedList = new ListNode(); // �����µĺϲ������������
        if (list1.val < list2.val) { // ע��ListNode��������ָ��ָ���׵�ַ���ݣ�����
            mergedList = list1; // ���ݲ�ͬ�����ʼ��������
            mergedList.next = mergeTwoLists(list1.next, list2); // recursion������
        } else {
            mergedList = list2;
            mergedList.next = mergeTwoLists(list1, list2.next);          
        }
        return mergedList;
    }
}