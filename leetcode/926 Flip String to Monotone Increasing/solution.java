class Solution {
    public int minFlipsMonoIncr(String s) { // 动态规划空间优化版本见Go答案！！！
        int n = s.length();
        int[][] d = new int[n][2];
        d[0][0] = s.charAt(0) == '0' ? 0 : 1; // d[i][0]表示前i个元素递增且第i个元素为0的最小翻转次数！！！
        d[0][1] = s.charAt(0) == '1' ? 0 : 1; // d[i][1]表示前i个元素递增且第i个元素为1的最小翻转次数！！！

        for (int i=1; i<n; i++) {
            char letter = s.charAt(i);
            d[i][0] = d[i-1][0] + (letter == '0' ? 0 : 1); // dp转移方程内包含判断！！！
            d[i][1] = Math.min(d[i-1][0], d[i-1][1]) + (letter == '1' ? 0 : 1);
        }
        return Math.min(d[n-1][0], d[n-1][1]); // 最终取二者中较小的结果！！！
    }
}