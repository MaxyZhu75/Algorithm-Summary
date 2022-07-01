class Solution {
    private String original;
    private String regular;
    
    public boolean isMatch(String s, String p) { // 复杂的动态规划转移方程；多看官方题解以及宫水三叶的证明！！！
        this.original = s;
        this.regular = p;
        int m = s.length(), n = p.length();

        boolean[][] d = new boolean[m+1][n+1];
        d[0][0] = true;
        for (int i=0; i<=m; i++) { // 细节一：填dp表时i从0开始，j从1开始！！！
            for (int j=1; j<=n; j++) {
                char current = regular.charAt(j-1);
				if (current == '*') { // case1：处理「*」，该符号仅能匹配他的前一个元素，故匹配时关注前一个元素！！！
                    if (matches(i, j-1)) {
                        d[i][j] = d[i-1][j] || d[i][j-2]; // 匹配成功，取d[i-1][j]代表决定替换original末尾的字符；取d[i][j-2]代表不替换！！！
                    } else {
                        d[i][j] = d[i][j-2]; // 匹配失败，取d[i][j-2]代表不替换！！！
                    }
                } else { // case2：非「*」，匹配时关注当前元素是否匹配！！！
                    if (matches(i, j)) {
                        d[i][j] = d[i-1][j-1];
                    } else {
                        d[i][j] = false;
                    }
                }
            }
        }
        return d[m][n];
    }

    public boolean matches(int i, int j) { // original「第i个字符」与regular「第j个字符」匹配情况！！！
        if (i == 0) {
            return false; // case1：original若为空则必然无法匹配！！！
        }
        if (regular.charAt(j-1) == '.') {
            return true; // case2: "." 可以匹配任意字母！！！
        }
        return original.charAt(i-1) == regular.charAt(j-1); // case3：两个字母本身相等！！！
    }
}