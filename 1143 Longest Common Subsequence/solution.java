class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] d = new int[m+1][n+1]; // 创建dp表！！！

        for (int i=0; i<=m; i++) { // 添加0边作为边界basecase；但其实数组初始化默认赋值已经是0（这两个循环可以不写）！！！
            d[i][0] = 0;
        }
        for (int j=0; j<=n; j++) {
            d[0][j] = 0;
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                char ithLetter = text1.charAt(i-1);
                char jthLetter = text2.charAt(j-1);
                if (ithLetter == jthLetter) { // 转移方程！！！
                    d[i][j] = d[i-1][j-1] + 1; // case1：该位置两边字符串字母匹配！！！
                } else {
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]); // case2：该位置两边字符串不匹配！！！
                }
            }
        }

        return d[m][n];
    }
}