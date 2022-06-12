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

class Solution { // �������⣺����ǳ����ҳ���δ֪����ʱ��ˮ�����������ʵ�ֿռ�O(1)������
    ListNode head; 
    Random random;

    public Solution(ListNode head) { // ���췽��������
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() { // ȡ����ڵ�ֵ����������ˮ�������ȸ���֤�����ٷ���𣡣���
        int result = 0;
		int i = 1; // ���������������ڵ�i���ڵ㣬���ѡ������[0,i)��һ����������������0���򽫴���Ϊ�ýڵ�ֵ������𰸲��䣡����
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