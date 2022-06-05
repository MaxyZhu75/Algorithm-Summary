public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) { // 动态规划！！！
        int n = s.length();
		Set<String> hashRecord = new HashSet(wordDict);
        boolean[] d = new boolean[n+1];
        d[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (d[j] && hashRecord.contains(s.substring(j, i))) { // 转移方程：d[i] = d[j] && check(s[j..i?1])！！！
                    d[i] = true;
                    break;
                }
            }
        }
        return d[n];
    }
}