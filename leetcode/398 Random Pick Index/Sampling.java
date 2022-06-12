class Solution { // 进阶问题：原数组非常大且长度未知；此时用水塘抽样则可以实现空间O(1)！！！
    int[] nums;
    Random random;

    public Solution(int[] nums) { // 构造方法！！！
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) { // 取指定元素的随机索引方法；关于水塘抽样等概率证明见官方解答！！！
        int result = 0;
		int k = 0; // 遍历数组，若第k次遇到target，此时随机选择区间[0,k)内的一个整数，如果其等于0，则返回值置为该元素的下标，否则返回值不变！！！
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                k++;
                if (random.nextInt(k) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */