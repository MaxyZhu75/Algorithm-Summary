class Solution {
    public long subArrayRanges(int[] nums) { // 进阶解法为单调栈！！！
        int n = nums.length;
        long result = 0;
        for (int i=0; i<n; i++) { // 考虑每个数作为子序列的开头！！！
            int min = nums[i];
            int max = nums[i];
            for (int j=i+1; j<n; j++) { // 动态更新当前子序列最大值最小值，并计入结果！！！
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += (long)max-min;
            }
        }
        return result;
    }
}