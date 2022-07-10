class Solution {
    public int maxSubarraySumCircular(int[] nums) { // 动态规划，空间优化版本见Go语言答案！！！
        int n = nums.length, total = 0;
        int[] dMax = new int[n+1]; // 答案在「数组中间」，就是「最大子序和」！！！
        int[] dMin = new int[n+1]; // 答案在「数组两边」，则是「total-最小的子序和」！！！
        for (int i=1; i<=n; i++) {
            dMax[i] = Math.max(dMax[i-1]+nums[i-1], nums[i-1]);
            dMin[i] = Math.min(dMin[i-1]+nums[i-1], nums[i-1]);
            total += nums[i-1];
        }
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            maxSum = Math.max(maxSum, dMax[i]);
            minSum = Math.min(minSum, dMin[i]);
        }
        return maxSum > 0 ? Math.max(maxSum, total-minSum) : maxSum; // 细节:「最大子序和」小于0，则返回maxSum！！！
    }
}