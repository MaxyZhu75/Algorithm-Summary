class Solution {
    public int maxResult(int[] nums, int k) { // 动态规划 +「空间优化单调队列」！！！
        int n = nums.length;
        int score = nums[0];
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, score}); // 数组实现键值对存储：{索引, 分数}！！！
        for (int i=1; i<n; i++) {
            while (deque.peekFirst() != null && deque.peekFirst()[0] < i-k) { // 清理左侧所有不在当前窗口内的元素！！！
                deque.pollFirst();
            }
            score = deque.peekFirst()[1] + nums[i]; // 计算当前索引i能得到的最大分数！！！
            while (deque.peekLast() != null && score >= deque.peekLast()[1]) {
                deque.pollLast(); // 当队尾分数小于新来的分数时，必然被直接弹出，不必再考虑该元素；「队列中最大分数会被移动到队首」！！！
            }
            deque.addLast(new int[]{i, score});
        }
        return score;
    }
}