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
    public boolean isPalindrome(ListNode head) { // 将链表分割为两部分，将后半部分反转与前半部分比较即可！！！
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head; // 要点一：基于快慢指针思想来确定链表的中间位置；此处需要注意快慢指针的起点！！！
        ListNode fast = head.next;
        while (fast != null && fast.next != null) { // 注意不能拿fast.next.next作判断条件，会发生空指针异常！！！
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHead = slow.next; // 要点二：结合实例可知无论原链表含奇数个节点还是偶数个节点，分割链表时后半部分的头结点总为慢指针所指的下一个节点！！！
        ListNode endFlag = fast == null ? slow : slow.next; // 要点三：由fast指针位置判断原链表节点数的奇偶；endFlag是为了进一步确定分割的位置；奇数个节点时正中间的节点既不在前半部分，也不在后半部分！！！
        
		cutLinkedList(head, endFlag);
        return isEqual(head,reverse(secondHead));
    }

    public void cutLinkedList(ListNode head, ListNode endFlag) { // 自定义的分割方法，发现下一个是endFlag则跳出循环指向null！！！
        while (head.next != endFlag) {
            head = head.next;
        }
        head.next = null;
    }

    public ListNode reverse(ListNode head) { // 头插法，该方法的解释见LeetCode的206题！！！
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

    public boolean isEqual(ListNode firstHead, ListNode secondHead) { // 判断两个链表是否相等！！！
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