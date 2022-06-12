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
    public ListNode sortList(ListNode head) { // �Ե����Ϲ鲢���� + ���� �������ռ临�Ӷȣ�����
        if (head == null) return head;
        int n = 0;
        ListNode node = head;
        while (node != null) { // ������ԭ������ n ������
            n++;
            node = node.next;
        }

        ListNode hair = new ListNode(0, head);
        for (int length = 1; length < n; length*=2) { // length��ʾÿ����Ҫ����ġ��������ȡ���ע��ÿ�ν�length��ֵ���ӱ���������
            ListNode previous = hair, current = hair.next;
            while (current != null) { // �������ֳ����ɸ�����Ϊlength�����������һ��������ĳ��ȿ���С��length��������ÿ����������һ����кϲ�������
                ListNode head1 = current;
                for (int i=1; i<length && current.next != null; i++) { // ��һ������������
                    current = current.next;
                }
                
				ListNode head2 = current.next; // ��ָ����д�������
                current.next = null;
                current = head2;
                
				for (int i=1; i<length && current != null && current.next != null; i++) { // �ڶ�������������
                    current = current.next;
                }

                ListNode nextNode = null; // ����ָ��ָ��Ϊ�ϲ���һ����������׼����nextNode����´ε���ʼ��������
                if (current != null) {
                    nextNode = current.next;
                    current.next = null;
                }

                ListNode merged = merge(head1, head2); // �ϲ���ǰ����������õ�����������������
                previous.next = merged;
                while (previous.next != null) {
                    previous = previous.next; // previous�������ϲ�����ĩβ��������
                }
                current = nextNode; // current����nextNode������
            }
        }
        return hair.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) { // LeetCode��21������ⷨ������
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