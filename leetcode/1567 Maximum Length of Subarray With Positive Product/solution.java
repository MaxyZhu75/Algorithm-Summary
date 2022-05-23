class Solution { // 空间优化版本见Go答案！！！
    public int getMaxLen(int[] nums) { // 分类动态规划！！！
        int n = nums.length;
        int[] positive = new int[n]; // positive[i] 表示以i结尾，乘积为正数的最长子数组长度！！！
        int[] negative = new int[n]; // negative[i] 表示以i结尾，乘积为负数的最长子数组长度！！！
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int result = positive[0];
        for (int i=1; i<n; i++) {
            if (nums[i] > 0) { // case1：nums[i]为正！！！
                positive[i] = positive[i-1] + 1;
                negative[i] = negative[i-1] > 0 ? negative[i-1] + 1 : 0;
            } else if (nums[i] < 0) { // case2：nums[i]为负！！！
                positive[i] = negative[i-1] > 0 ? negative[i-1] + 1 : 0;
                negative[i] = positive[i-1] + 1;
            } else { // case3：nums[i]为0！！！
                positive[i] = 0;
                negative[i] = 0;
            }
            result = Math.max(result, positive[i]);
        }
        return result;
    }
}