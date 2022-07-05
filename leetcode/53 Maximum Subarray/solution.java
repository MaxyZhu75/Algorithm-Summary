class Solution {
    public int maxSubArray(int[] nums) { // 动态规划空间优化版；另外官方解答有分治解法！！！
        int current = 0;
        int max = nums[0];
        for (int num : nums) { // 此处逻辑为：若current+num小于num，说明此前最大子串之和current为负数，则直接摒弃num之前的数使current等于num！！！
            current = Math.max(current+num, num); // d[i] = max(d[i-1]+nums[i], nums[i])！！！
            max = Math.max(max, current);
        }
        return max;
    }
}
