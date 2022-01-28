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
    public ListNode removeNthFromEnd(ListNode head, int n) { // ����˫ָ���������ȷ���������λ�ã�����
        ListNode p1 = head;
        ListNode p2 = head;
        
        for(int i=0; i<n; i++) { // ��ϵʵ����֪��p2����n��������p1��p2һ���ߣ�ֱ��p2����ĩβ�����Ա�֤p1��ָ������ԭ����ĵ�����n+1���ڵ㣡����
            p2 = p2.next;
        }

        if (p2 == null) { // Ҫ�㣺�����ƽڵ������£��˴�����ͨ���÷�ʽ�ж���Ҫɾ���Ľڵ��Ƿ�Ϊͷ�ڵ㣻����Ҫɾ������ͷ��㣬��ֱ�ӷ���head.next������
            return head.next;
        }

        while(p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        
        p1.next = p1.next.next; // ����p1��ָ������ԭ����ĵ�����n+1���ڵ㣬�˴�����headִ��ɾ��������n���ڵ�Ĳ������÷�ʽ����ɾ��ͷ��㣬ӦԤ�ȶ��Ƿ�ɾ��ͷ�������жϺʹ���������
        
        return head;
    }
}