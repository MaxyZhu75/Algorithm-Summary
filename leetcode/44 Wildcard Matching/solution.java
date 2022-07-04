class Solution {
    private String original;
    private String regular;
    
    public boolean isMatch(String s, String p) { // ����LeetCode��10��������ƥ�䣡����
        this.original = s;
        this.regular = p;
        int m = s.length(), n = p.length();
        boolean[][] d = new boolean[m+1][n+1];
        d[0][0] = true;
        for (int j=1; j<=n; j++) { // ϸ��һ�����⡸*������ƥ�������ַ������������ַ����������ܸ�ǿ������
            if (regular.charAt(j-1) == '*') {
                d[0][j] = true;
            } else {
                break;
            }
        }

        for (int i=1; i<=m; i++) { // ϸ�ڶ�����dp��ʱi��1��ʼ��j��1��ʼ������
            for (int j=1; j<=n; j++) {
                char current = regular.charAt(j-1);
				if (current == '*') {
                    d[i][j] = d[i][j-1] || d[i-1][j]; // ȡd[i-1][j]��������滻originalĩβ���ַ���ȡd[i][j-1]�����滻�ַ�������
                } else if (matches(i, j)) {
                    d[i][j] = d[i-1][j-1];
                }
            }
        }
        return d[m][n];
    }
    
    public boolean matches(int i, int j) { // original����i���ַ�����regular����j���ַ���ƥ�����������
        if (regular.charAt(j-1) == '?') {
            return true; // case1: "?" ����ƥ��������ĸ������
        }
        return original.charAt(i-1) == regular.charAt(j-1); // case2��������ĸ������ȣ�����
    }
}