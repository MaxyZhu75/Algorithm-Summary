class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) { // 至少一个字符串为空串！！！
            return m + n;
        }

        int[][] d = new int[m+1][n+1]; // d[i][j]表示「A的前i个字母」和「B的前j个字母」之间的编辑距离！！！

        for (int i=0; i<m+1; i++) { // 边界条件！！！
            d[i][0] = i;
        }
        for (int j=0; j<n+1; j++) {
            d[0][j] = j;
        }

        for (int i=1; i<m + 1; i++) { // 结论：有意义的操作实际上只有三种:「在A末尾插入字符」,「在B的末尾插入字符」,「替换A末尾的字符」！！！
            for (int j=1; j<n+1; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) { // case1：末尾字母相同；d[i][j]=min(d[i][j?1]+1, d[i?1][j]+1, d[i?1][j?1]+1)！！！
                    d[i][j] = Math.min(d[i-1][j]+1, Math.min(d[i][j-1]+1, d[i-1][j-1]+1));
                } else { // case2：末尾字母不同(替换操作需要+1)；d[i][j]=min(d[i][j?1]+1, d[i?1][j]+1, d[i?1][j?1])！！！
				    d[i][j] = Math.min(d[i-1][j]+1, Math.min(d[i][j-1]+1, d[i-1][j-1]));
				}
            }
        }
        return d[m][n];
    }
}