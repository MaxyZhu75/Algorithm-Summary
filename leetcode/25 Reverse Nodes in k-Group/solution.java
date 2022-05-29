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
    public ListNode reverseKGroup(ListNode head, int k) { // ��Ҫ����������ɣ�����
        ListNode hair = new ListNode(0); 
        hair.next = head; // ��������hair�ڵ�������������������
        ListNode preTail = hair;
		ListNode tail = null, nextHead = null;
        
        while (head != null) {
            tail = preTail; // ��tail�ƻ�preTail�����鿴ʣ�ಿ�ֳ����Ƿ���ڵ���k������
            for (int i=0; i<k; i++) {
                tail = tail.next;
                if (tail == null) return hair.next;
            }
			
            nextHead = tail.next; // �Ͽ���ǰ��������һ���֣������з�ת������
			tail.next = null;
            ListNode[] nodes = reverseList(head, tail);
            head = nodes[0]; // ��ת����µ�ǰhead��tail������
            tail = nodes[1];

            preTail.next = head; // ���ò������½ӻ�ԭ������ͷβ���д�����������preTail��headλ�ã�����
            tail.next = nextHead;
            preTail = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] reverseList(ListNode head, ListNode tail) { // ��LeetCode��206�⣡����
        ListNode previous = null;
        ListNode current = head;
        while (current != null){
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return new ListNode[]{tail, head};
    }
}