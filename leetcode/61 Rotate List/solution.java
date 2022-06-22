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
    public ListNode rotateRight(ListNode head, int k) { // ���ȱպ�Ϊ�������ҵ�β���Ͽ���������
        if (head == null || head.next == null) return head;
        int n = 1; // ͳ�������ȣ�����
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }
        k = k % n; // �ƶ�n��������ʱ�൱��δ�ƶ�������
        if (k == 0) return head;
        node.next = head; // ����һ���պ�Ϊ����ʹβ�ڵ�ָ��ָ��ͷ�ڵ㣡����
		int steps = n-k;
        while (steps-- > 0) { // ���������ƶ���n-k�������ɵ����������β�ڵ㣡����
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}