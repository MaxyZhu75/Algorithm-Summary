class Solution {
    public int maxProfit(int[] prices) { // DP��״̬ת�����⣬�ؼ�Ū�������״̬��״̬���壡����
        int n = prices.length;
        int[][] d = new int[n][3];

        d[0][0] = -prices[0]; // basecase������
        d[0][1] = 0;
        d[0][2] = 0;

        for (int i=1; i<n; i++) { // ����dp״̬����ֻ��ǰһ��״̬�йأ�Go���Դ�Ϊ�ռ��Ż��汾������
            d[i][0] = Math.max(d[i-1][0], d[i-1][1]-prices[i]); // ״̬0����i����������ϳ����Ź�Ʊ����¼��ʱ������棡����
            d[i][1] = Math.max(d[i-1][1], d[i-1][2]); // ״̬1����i����������ϲ����й�Ʊ���Ҳ������䶳�ڣ���¼��ʱ������棡����
            d[i][2] = d[i-1][0] + prices[i]; // ״̬2����i����������ϲ����й�Ʊ���Ҵ����䶳�ڣ���¼��ʱ������棡����
        }

        return Math.max(d[n-1][1], d[n-1][2]); // ���һ��ϣ������������Ϲ�Ʊ�϶��Ѷ�����·���������ںɰ������
    }
}