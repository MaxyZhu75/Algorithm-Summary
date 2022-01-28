class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result = 1;
        int[] d = new int[n+1];
        d[0] = 0; // basecase！！！
        d[1] = 1;
        for (int i=2; i<n+1; i++) { // 外层：将dp表每一格填完！！！
            d[i] = 1; // basecase全都置为1！！！
            for (int j=1; j<i; j++) { // 内层：填某一格时遍历所有情况！！！
                if (nums[i-1] > nums[i-1-j]) {
                    d[i] = Math.max(d[i], d[i-j]+1);
                }
            }
            result = Math.max(result, d[i]); // 更新当前dp表中最大长度子序列！！！
        }
        return result;
    }
}