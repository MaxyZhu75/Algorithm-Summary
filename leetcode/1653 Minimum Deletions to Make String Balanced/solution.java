class Solution {
    public int minimumDeletions(String s) { // 同LeetCode第926题！！！
        int n = s.length();
        int[][] d = new int[n][2];
        d[0][0] = (s.charAt(0) == 'a') ? 0 : 1; // d[i][0]表示前i个元素递增且第i个元素为a的最小翻转次数！！！
        d[0][1] = (s.charAt(0) == 'b') ? 0 : 1; // d[i][1]表示前i个元素递增且第i个元素为b的最小翻转次数！！！
        for (int i=1; i<n; i++) {
            d[i][0] = d[i-1][0] + (s.charAt(i) == 'a' ? 0 : 1); // dp转移方程内包含判断！！！
            d[i][1] = Math.min(d[i-1][0], d[i-1][1]) + (s.charAt(i) == 'b' ? 0 : 1);
        }
        return Math.min(d[n-1][0], d[n-1][1]); // 最终取二者中较小的结果！！！
    }
}