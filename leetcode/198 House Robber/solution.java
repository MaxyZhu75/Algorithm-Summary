class Solution {
    public int rob(int[] nums) { // dp空间优化方法见Go语言答案！！！
        int n = nums.length;
        int[] d = new int[n+1];
        d[0] = 0;
        d[1] = nums[0];
        for (int i=2; i<n+1; i++) {
            d[i] = Math.max(d[i-1], d[i-2]+nums[i-1]); // 这样填dp代码比较简短，但是注意nums下标即可（nums下标和dp表下标含义不统一）！！！
        }

        return d[n];
    }
}