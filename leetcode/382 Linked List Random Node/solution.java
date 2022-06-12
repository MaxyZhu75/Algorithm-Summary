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

class Solution { // 存储链表所有元素值；空间为O(n)！！！
    List<Integer> values = new ArrayList<>(); // Solution类两个类变量！！！
    Random random; // import java.util.Random！！！

    public Solution(ListNode head) { // 构造方法！！！
		this.random = new Random();
		while (head != null) {
            values.add(head.val); // 存储所有节点值！！！
            head = head.next;
        }
    }

    public int getRandom() { // 取随机数方法！！！
        int randomNum = random.nextInt(values.size());
        return values.get(randomNum);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */