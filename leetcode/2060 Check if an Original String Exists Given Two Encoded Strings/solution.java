class Solution {
    public boolean possiblyEquals(String s1, String s2) { // 动态规划；具体分析见题解！！！
        int m = s1.length(), n = s2.length();
        char[] letters1 = s1.toCharArray(), letters2 = s2.toCharArray();
		
		Set<Integer>[][] d = new Set[m+1][n+1]; // dp表使用二维Set集合！！！
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                d[i][j] = new HashSet<>(); // 下拉HashSet；d[i][j]表示s1前i个字母与s2前j个字母匹配且不发生冲突时，可能的长度差值！！！
            }
        }
        d[0][0].add(0);

        int num = 0;
		for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                for (int difference : d[i][j]) {
                    num = 0;
                    if (difference <= 0) { // 优化填表；要求difference小于等于0！！！
						for (int k=i; k < Math.min(i+3, m) && isDigit(letters1[k]); k++) { // s1[i][j]到s1[k][j]为数字！！！
							num = num * 10 + letters1[k] - '0';
							d[k+1][j].add(difference + num);
						}	
					}

                    num = 0;
                    if (difference >= 0) { // 优化填表；要求difference大于等于0！！！
						for (int k=j; k < Math.min(j+3, n) && isDigit(letters2[k]); k++) { // s2[i][j]到s1[i][k]为数字！！！
							num = num * 10 + letters2[k] - '0';
							d[i][k+1].add(difference - num);
						}
                    }

                    if (i < m && !isDigit(letters1[i]) && difference < 0) { // 若s1[i]是字母，且该字母可以被s2长度匹配（要求difference小于0）！！！
                        d[i+1][j].add(difference + 1);
                    }

                    if (j < n && !isDigit(letters2[j]) && difference > 0) { // 若s2[j]是字母，且该字母可以被s1长度匹配（要求difference大于0）！！！
                        d[i][j+1].add(difference - 1);
                    }

                    if (i < m && j < n && !isDigit(letters1[i]) && letters1[i] == letters2[j] && difference == 0) { // s1[i]与s2[j]两个字母匹配（要求difference等于0）！！！
                        d[i+1][j+1].add(difference);
                    }
                }
            }
        }

        return d[m][n].contains(0); // 检查d[m][n]是否包含0！！！
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}