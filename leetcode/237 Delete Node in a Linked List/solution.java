/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public void deleteNode(ListNode node) { // 由于无法访问head，必然无法知道前驱节点；只能伪装成儿子，跳过儿子直接养孙子！！！
        node.val = node.next.val;
        node.next = node.next.next;
    }
}