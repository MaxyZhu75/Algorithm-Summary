class Solution {
    public int minimumDeletions(String s) { // ͬLeetCode��926�⣡����
        int n = s.length();
        int[][] d = new int[n][2];
        d[0][0] = (s.charAt(0) == 'a') ? 0 : 1; // d[i][0]��ʾǰi��Ԫ�ص����ҵ�i��Ԫ��Ϊa����С��ת����������
        d[0][1] = (s.charAt(0) == 'b') ? 0 : 1; // d[i][1]��ʾǰi��Ԫ�ص����ҵ�i��Ԫ��Ϊb����С��ת����������
        for (int i=1; i<n; i++) {
            d[i][0] = d[i-1][0] + (s.charAt(i) == 'a' ? 0 : 1); // dpת�Ʒ����ڰ����жϣ�����
            d[i][1] = Math.min(d[i-1][0], d[i-1][1]) + (s.charAt(i) == 'b' ? 0 : 1);
        }
        return Math.min(d[n-1][0], d[n-1][1]); // ����ȡ�����н�С�Ľ��������
    }
}