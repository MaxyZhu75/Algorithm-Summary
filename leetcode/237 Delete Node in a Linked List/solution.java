/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public void deleteNode(ListNode node) { // �����޷�����head����Ȼ�޷�֪��ǰ���ڵ㣻ֻ��αװ�ɶ��ӣ���������ֱ�������ӣ�����
        node.val = node.next.val;
        node.next = node.next.next;
    }
}