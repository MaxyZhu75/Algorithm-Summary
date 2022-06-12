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

class Solution { // �洢��������Ԫ��ֵ���ռ�ΪO(n)������
    List<Integer> values = new ArrayList<>(); // Solution�����������������
    Random random; // import java.util.Random������

    public Solution(ListNode head) { // ���췽��������
		this.random = new Random();
		while (head != null) {
            values.add(head.val); // �洢���нڵ�ֵ������
            head = head.next;
        }
    }

    public int getRandom() { // ȡ���������������
        int randomNum = random.nextInt(values.size());
        return values.get(randomNum);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */