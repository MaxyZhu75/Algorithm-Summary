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
    public ListNode reverseKGroup(ListNode head, int k) { // 按要求对链表处理即可！！！
        ListNode hair = new ListNode(0); 
        hair.next = head; // 必须设置hair节点来帮助返回链表！！！
        ListNode preTail = hair;
		ListNode tail = null, nextHead = null;
        
        while (head != null) {
            tail = preTail; // 将tail移回preTail帮助查看剩余部分长度是否大于等于k！！！
            for (int i=0; i<k; i++) {
                tail = tail.next;
                if (tail == null) return hair.next;
            }
			
            nextHead = tail.next; // 断开当前部分与下一部分，并进行反转！！！
			tail.next = null;
            ListNode[] nodes = reverseList(head, tail);
            head = nodes[0]; // 反转后更新当前head与tail！！！
            tail = nodes[1];

            preTail.next = head; // 将该部分重新接回原链表（对头尾进行处理），并更新preTail与head位置！！！
            tail.next = nextHead;
            preTail = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] reverseList(ListNode head, ListNode tail) { // 见LeetCode第206题！！！
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