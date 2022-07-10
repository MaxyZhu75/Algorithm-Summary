class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result = 1;
        int[] d = new int[n+1]; // d[i]代表数组以nums[i-1]结尾的最长上升子序列！！！
        d[0] = 0;
        d[1] = 1;
        for (int i=2; i<n+1; i++) {
            d[i] = 1; // 计数至少包含元素本身！！！
            for (int j=1; j<i; j++) { // 以nums[i-1]为结尾，往左找！！！
                if (nums[i-1] > nums[i-1-j]) {
                    d[i] = Math.max(d[i], d[i-j]+1); // 细节：对比当前结果与从nums[i-1-j]跳转过来的结果！！！
                }
            }
            result = Math.max(result, d[i]);
        }
        return result;
    }
}
