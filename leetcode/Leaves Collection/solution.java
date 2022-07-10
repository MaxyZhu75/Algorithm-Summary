class Solution {
    public int minimumOperations(String leaves) { // ��̬�滮������
        int n = leaves.length();
        int[][] d = new int[n][3]; // ����״̬������
        d[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        d[0][1] = d[0][2] = d[1][2] = Integer.MAX_VALUE; // ϸ�ڣ����С�i<j����״̬���ǲ�����Ҫ��ģ�����
        for (int i=1; i<n; i++) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            d[i][0] = d[i-1][0] + isYellow;
            d[i][1] = Math.min(d[i-1][0], d[i-1][1]) + isRed;
            if (i >= 2) {
                d[i][2] = Math.min(d[i-1][1], d[i-1][2]) + isYellow;
            }
        }
        return d[n-1][2];
    }
}