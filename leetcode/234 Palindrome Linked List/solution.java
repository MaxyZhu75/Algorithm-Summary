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
    public boolean isPalindrome(ListNode head) { // ������ָ�Ϊ�����֣�����벿�ַ�ת��ǰ�벿�ֱȽϼ��ɣ�����
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head; // Ҫ��һ�����ڿ���ָ��˼����ȷ��������м�λ�ã��˴���Ҫע�����ָ�����㣡����
        ListNode fast = head.next;
        while (fast != null && fast.next != null) { // ע�ⲻ����fast.next.next���ж��������ᷢ����ָ���쳣������
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHead = slow.next; // Ҫ��������ʵ����֪����ԭ�����������ڵ㻹��ż�����ڵ㣬�ָ�����ʱ��벿�ֵ�ͷ�����Ϊ��ָ����ָ����һ���ڵ㣡����
        ListNode endFlag = fast == null ? slow : slow.next; // Ҫ��������fastָ��λ���ж�ԭ����ڵ�������ż��endFlag��Ϊ�˽�һ��ȷ���ָ��λ�ã��������ڵ�ʱ���м�Ľڵ�Ȳ���ǰ�벿�֣�Ҳ���ں�벿�֣�����
        
		cutLinkedList(head, endFlag);
        return isEqual(head,reverse(secondHead));
    }

    public void cutLinkedList(ListNode head, ListNode endFlag) { // �Զ���ķָ����������һ����endFlag������ѭ��ָ��null������
        while (head.next != endFlag) {
            head = head.next;
        }
        head.next = null;
    }

    public ListNode reverse(ListNode head) { // ͷ�巨���÷����Ľ��ͼ�LeetCode��206�⣡����
        if (head == null || head.next == null) {
            return head;
        }
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

    public boolean isEqual(ListNode firstHead, ListNode secondHead) { // �ж����������Ƿ���ȣ�����
        while (firstHead != null && secondHead!= null) {
            if (firstHead.val != secondHead.val) {
                return false;
            } else {
                firstHead = firstHead.next;
                secondHead = secondHead.next;
            }
        }
        return true;
    }

}