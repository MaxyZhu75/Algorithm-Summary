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

class Solution { // 进阶问题：链表非常大且长度未知；此时用水塘抽样则可以实现空间O(1)！！！
    ListNode head; 
    Random random;

    public Solution(ListNode head) { // 构造方法！！！
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() { // 取随机节点值方法；关于水塘抽样等概率证明见官方解答！！！
        int result = 0;
		int i = 1; // 遍历整个链表，对于第i个节点，随机选择区间[0,i)内一个整数，如果其等于0，则将答案置为该节点值，否则答案不变！！！
		ListNode node = head;
        while (node != null) {
            if (random.nextInt(i) == 0) {
                result = node.val;
            }
            i++;
			node = node.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */