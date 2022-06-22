class Solution {
    public int maxResult(int[] nums, int k) { // ��̬�滮 +���ռ��Ż��������С�������
        int n = nums.length;
        int score = nums[0];
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, score}); // ����ʵ�ּ�ֵ�Դ洢��{����, ����}������
        for (int i=1; i<n; i++) {
            while (deque.peekFirst() != null && deque.peekFirst()[0] < i-k) { // ����������в��ڵ�ǰ�����ڵ�Ԫ�أ�����
                deque.pollFirst();
            }
            score = deque.peekFirst()[1] + nums[i]; // ���㵱ǰ����i�ܵõ���������������
            while (deque.peekLast() != null && score >= deque.peekLast()[1]) {
                deque.pollLast(); // ����β����С�������ķ���ʱ����Ȼ��ֱ�ӵ����������ٿ��Ǹ�Ԫ�أ����������������ᱻ�ƶ������ס�������
            }
            deque.addLast(new int[]{i, score});
        }
        return score;
    }
}