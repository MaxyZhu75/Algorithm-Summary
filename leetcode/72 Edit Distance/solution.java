class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) { // ����һ���ַ���Ϊ�մ�������
            return m + n;
        }

        int[][] d = new int[m+1][n+1]; // d[i][j]��ʾ��A��ǰi����ĸ���͡�B��ǰj����ĸ��֮��ı༭���룡����

        for (int i=0; i<m+1; i++) { // �߽�����������
            d[i][0] = i;
        }
        for (int j=0; j<n+1; j++) {
            d[0][j] = j;
        }

        for (int i=1; i<m + 1; i++) { // ���ۣ�������Ĳ���ʵ����ֻ������:����Aĩβ�����ַ���,����B��ĩβ�����ַ���,���滻Aĩβ���ַ���������
            for (int j=1; j<n+1; j++) {
                if (word1.charAt(i-1) != word2.charAt(j-1)) { // case1��ĩβ��ĸ��ͬ��d[i][j]=min(d[i][j?1]+1, d[i?1][j]+1, d[i?1][j?1]+1)������
                    d[i][j] = Math.min(d[i-1][j]+1, Math.min(d[i][j-1]+1, d[i-1][j-1]+1));
                } else { // case2��ĩβ��ĸ��ͬ(�滻������Ҫ+1)��d[i][j]=min(d[i][j?1]+1, d[i?1][j]+1, d[i?1][j?1])������
				    d[i][j] = Math.min(d[i-1][j]+1, Math.min(d[i][j-1]+1, d[i-1][j-1]));
				}
            }
        }
        return d[m][n];
    }
}