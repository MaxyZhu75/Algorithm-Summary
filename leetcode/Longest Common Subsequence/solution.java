import java.util.*;

public class Solution {
    public String LCS (String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] d = new int[m+1][n+1]; // 表示s1到第i个字符，s2到第j个字符为止的公共子串长度！！！
        int longest = 0, end = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1] + 1; // case1：该位置两边字符串字母匹配！！！
                } else {
                    d[i][j] = 0; // case2：该位置两边字符串不匹配！！！
                }
                if (longest < d[i][j]) { // 记录最长公共子串的结束位置和长度，便于返回子串结果！！！
                    longest = d[i][j];
                    end = i-1;
                }
            }
        }
        return str1.substring(end-longest+1, end+1);
    }
}