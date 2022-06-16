public class Solution {
    public int findKthLargest(int[] nums, int k) { // �������ȶ���ʵ�ֶѣ�����
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1-o2); // ������С�ѣ�����
        for (int i=0; i<k; i++) {
            minHeap.add(nums[i]); // ����ѵĴ�СΪk������
        }
        for (int i=k; i<n; i++) {
            if (nums[i] > minHeap.peek()) { // ��������Ԫ�ش�����С�ѶѶ����򵯳��Ѷ�Ԫ�أ���������Ԫ����ѣ�����
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}