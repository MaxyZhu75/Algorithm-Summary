class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) { // 要点：该题等价于LeetCode1143最长公共子序列问题！！！
        int n = nums1.length;
        int m = nums2.length;
        int[][] d = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    d[i][j] = d[i-1][j-1] + 1; // case1：该位置两边字符串字母匹配！！！
                } else {
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]); // case2：该位置两边字符串不匹配！！！
                }
            }
        }
        return d[n][m];
    }
}