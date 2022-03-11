class Solution {
    public int minDistance(String word1, String word2) { // 该题即最长公共子序列问题，请见LeetCode1143题！！！
        int m = word1.length();
        int n = word2.length();
        int[][] d = new int[m+1][n+1];
        
        for (int i=0; i<=m; i++) {
            d[i][0] = 0;
        }
        for (int j=0; j<=n; j++) {
            d[0][j] = 0;
        }
        
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                char ithLetter = word1.charAt(i-1);
                char jthLetter = word2.charAt(j-1);
                if (ithLetter == jthLetter) {
                    d[i][j] = d[i-1][j-1] + 1;
                } else {
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }

        return m+n-2*d[m][n]; // 返回结果！！！
    }
}