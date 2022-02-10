class Solution {
    public int maxProfit(int[] prices, int fee) { // DP��״̬ת�����⣬�ؼ�Ū�������״̬��״̬���壻��LeetCode309�����ƣ�����
        int n = prices.length;
        int[][] d = new int[n][2];

        d[0][0] = -prices[0]; // basecase������
        d[0][1] = 0;
        for (int i=1; i<n; i++) { // ����dp״̬����ֻ��ǰһ��״̬�йأ�Go���Դ�Ϊ�ռ��Ż��汾������
            d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i]); // ״̬0����i����������ϳ����Ź�Ʊ����¼��ʱ������棡����
            d[i][1] = Math.max(d[i-1][0]+prices[i]-fee, d[i-1][1]); // ״̬1����i����������ϲ����й�Ʊ����¼��ʱ������棡����
        }

        return d[n-1][1]; // ���һ��ϣ������������Ϲ�Ʊ�϶��Ѷ�����·���������������ںɰ������
    }
}