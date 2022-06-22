class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) { //「双端队列」实现「单调队列」；线性时间完成！！！
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<k; i++) { // 窗口内第一组元素处理；添加元素的方法在时间上优于堆（优先队列）！！！
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast(); // 当队尾元素小于新来的元素时，必然被直接弹出，不必再考虑该元素；「最大值会被移动到队首」！！！
            }
            deque.addLast(i); // 存储元素索引！！！
        }

        int[] result = new int[n-k+1];
        result[0] = nums[deque.peekFirst()];
        for (int i=k; i<n; i++) { // 滑动窗口，即对新来的元素遍历！！！
            while (deque.peekFirst() != null && deque.peekFirst() <= i-k) { // 清理左侧所有不在当前窗口内的元素！！！
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