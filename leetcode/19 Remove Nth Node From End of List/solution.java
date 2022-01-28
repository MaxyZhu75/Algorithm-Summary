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
    public ListNode removeNthFromEnd(ListNode head, int n) { // 利用双指针帮助链表确定具体操作位置！！！
        ListNode p1 = head;
        ListNode p2 = head;
        
        for(int i=0; i<n; i++) { // 联系实例可知，p2先走n步，再让p1与p2一起走，直至p2到达末尾，可以保证p1的指向落在原链表的倒数第n+1个节点！！！
            p2 = p2.next;
        }

        if (p2 == null) { // 要点：在无哑节点的情况下，此处必须通过该方式判断需要删除的节点是否为头节点；若需要删除的是头结点，则直接返回head.next！！！
            return head.next;
        }

        while(p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        
        p1.next = p1.next.next; // 由于p1的指向落在原链表的倒数第n+1个节点，此处帮助head执行删除倒数第n个节点的操作（该方式不能删除头结点，应预先对是否删除头结点进行判断和处理）！！！
        
        return head;
    }
}