class Solution { // dp空间优化方法见Go语言答案！！！
    public int rob(int[] nums) { // 该题是基于LeetCode198题的动态规划！！！
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int robEntry = houseRobber(nums, 0, n-2); // case1：抢循环的入口，不抢末尾！！！
        int passEntry = houseRobber(nums, 1, n-1); // case2：不抢循环的入口，抢末尾！！！
        return Math.max(robEntry, passEntry);
    }

    public int houseRobber(int[] nums, int start, int end) { // 见LeetCode198题，此处需注意当使用原nums数组时，要从start索引开始即可（视作索引0）！！！
        int n = end - start + 1;
        int d[] = new int[n+1];
        d[0] = 0;
        d[1] = nums[start];
        for (int i=2; i<n+1; i++) {
            d[i] = Math.max(d[i-1], d[i-2]+nums[start+i-1]);
        }

        return d[n];
    }
}