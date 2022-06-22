class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) { //��˫�˶��С�ʵ�֡��������С�������ʱ����ɣ�����
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<k; i++) { // �����ڵ�һ��Ԫ�ش������Ԫ�صķ�����ʱ�������ڶѣ����ȶ��У�������
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast(); // ����βԪ��С��������Ԫ��ʱ����Ȼ��ֱ�ӵ����������ٿ��Ǹ�Ԫ�أ������ֵ�ᱻ�ƶ������ס�������
            }
            deque.addLast(i); // �洢Ԫ������������
        }

        int[] result = new int[n-k+1];
        result[0] = nums[deque.peekFirst()];
        for (int i=k; i<n; i++) { // �������ڣ�����������Ԫ�ر���������
            while (deque.peekFirst() != null && deque.peekFirst() <= i-k) { // ����������в��ڵ�ǰ�����ڵ�Ԫ�أ�����
                deque.pollFirst();
            }
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);

            result[i-k+1] = nums[deque.peekFirst()];
        }
        return result;
    }
}