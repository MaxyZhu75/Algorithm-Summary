public class Solution {
    public int findKthLargest(int[] nums, int k) { // 内置优先队列实现堆！！！
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1-o2); // 创建最小堆！！！
        for (int i=0; i<k; i++) {
            minHeap.add(nums[i]); // 构造堆的大小为k！！！
        }
        for (int i=k; i<n; i++) {
            if (nums[i] > minHeap.peek()) { // 若新来的元素大于最小堆堆顶；则弹出堆顶元素，将新来的元素入堆！！！
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}