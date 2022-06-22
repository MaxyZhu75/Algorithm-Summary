class Solution {
    public int numSquares(int n) { // ��̬�滮����������Ǯ���⣩������
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) { // d[i]��ʾ������Ҫ���ٸ�����ƽ������ʾ����i������
            int minPre = Integer.MAX_VALUE;
            for (int j=1; j*j <= i; j++) {
                minPre = Math.min(minPre, d[i - j*j]);
            }
            d[i] = minPre + 1; // ת�Ʒ��̣�d[i] = min{d[i-j^2]}+1 ������
        }
        return d[n];
    }
}