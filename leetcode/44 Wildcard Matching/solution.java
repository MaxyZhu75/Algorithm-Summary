class Solution {
    private String original;
    private String regular;
    
    public boolean isMatch(String s, String p) { // 类似LeetCode第10题正则表达匹配！！！
        this.original = s;
        this.regular = p;
        int m = s.length(), n = p.length();
        boolean[][] d = new boolean[m+1][n+1];
        d[0][0] = true;
        for (int j=1; j<=n; j++) { // 细节一：本题「*」可以匹配任意字符串（包括空字符串），功能更强！！！
            if (regular.charAt(j-1) == '*') {
                d[0][j] = true;
            } else {
                break;
            }
        }

        for (int i=1; i<=m; i++) { // 细节二：填dp表时i从1开始，j从1开始！！！
            for (int j=1; j<=n; j++) {
                char current = regular.charAt(j-1);
				if (current == '*') {
                    d[i][j] = d[i][j-1] || d[i-1][j]; // 取d[i-1][j]代表决定替换original末尾的字符；取d[i][j-1]代表不替换字符！！！
                } else if (matches(i, j)) {
                    d[i][j] = d[i-1][j-1];
                }
            }
        }
        return d[m][n];
    }
    
    public boolean matches(int i, int j) { // original「第i个字符」与regular「第j个字符」匹配情况！！！
        if (regular.charAt(j-1) == '?') {
            return true; // case1: "?" 可以匹配任意字母！！！
        }
        return original.charAt(i-1) == regular.charAt(j-1); // case2：两个字母本身相等！！！
    }
}