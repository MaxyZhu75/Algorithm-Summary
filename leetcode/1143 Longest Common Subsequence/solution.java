class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] d = new int[m+1][n+1]; // ����dp������

        for (int i=0; i<=m; i++) { // ���0����Ϊ�߽�basecase������ʵ�����ʼ��Ĭ�ϸ�ֵ�Ѿ���0��������ѭ�����Բ�д��������
            d[i][0] = 0;
        }
        for (int j=0; j<=n; j++) {
            d[0][j] = 0;
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                char ithLetter = text1.charAt(i-1);
                char jthLetter = text2.charAt(j-1);
                if (ithLetter == jthLetter) { // ת�Ʒ��̣�����
                    d[i][j] = d[i-1][j-1] + 1; // case1����λ�������ַ�����ĸƥ�䣡����
                } else {
                    d[i][j] = Math.max(d[i][j-1], d[i-1][j]); // case2����λ�������ַ�����ƥ�䣡����
                }
            }
        }

        return d[m][n];
    }
}