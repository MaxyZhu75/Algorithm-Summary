class Solution {
    public int minFlipsMonoIncr(String s) { // ��̬�滮�ռ��Ż��汾��Go�𰸣�����
        int n = s.length();
        int[][] d = new int[n][2];
        d[0][0] = s.charAt(0) == '0' ? 0 : 1; // d[i][0]��ʾǰi��Ԫ�ص����ҵ�i��Ԫ��Ϊ0����С��ת����������
        d[0][1] = s.charAt(0) == '1' ? 0 : 1; // d[i][1]��ʾǰi��Ԫ�ص����ҵ�i��Ԫ��Ϊ1����С��ת����������

        for (int i=1; i<n; i++) {
            char letter = s.charAt(i);
            d[i][0] = d[i-1][0] + (letter == '0' ? 0 : 1); // dpת�Ʒ����ڰ����жϣ�����
            d[i][1] = Math.min(d[i-1][0], d[i-1][1]) + (letter == '1' ? 0 : 1);
        }
        return Math.min(d[n-1][0], d[n-1][1]); // ����ȡ�����н�С�Ľ��������
    }
}