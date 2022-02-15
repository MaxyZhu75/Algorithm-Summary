class Solution {
    public int maxProfit(int[] prices) { // Ҫ��һ���������ʱʼ�ռ�ס��������Ŀ���Ƿ���������ͬһ�����벢����������һ���������յĴ𰸶������ܵ�Ӱ�죬��Ϊ��һ��������������Ϊ�㣡����
        int n = prices.length;
        int[][] d = new int[n][4]; // DP��״̬ת�����⣬�ؼ�Ū�������״̬��״̬���壻��LeetCode309�����ƣ�����

        d[0][0] = -prices[0]; // basecase������
        d[0][1] = 0;
        d[0][2] = -prices[0];
        d[0][3] = 0;

        for (int i=1; i<n; i++) { // ����dp״̬����ֻ��ǰһ��״̬�йأ�Go���Դ�Ϊ�ռ��Ż��汾������
            d[i][0] = Math.max(d[i-1][0], -prices[i]); // ״̬0����i����������ϳ��е�һ��������Ĺ�Ʊ����¼��ʱ������棡����
            d[i][1] = Math.max(d[i-1][0]+prices[i], d[i-1][1]); // ״̬1����i��������������ڵ�һ��������͵�һ���������������У���¼��ʱ������棡����
            d[i][2] = Math.max(d[i-1][1]-prices[i], d[i-1][2]); // ״̬2����i����������һ�ʽ��׵�ǰ���£����ϳ��еڶ���������Ĺ�Ʊ����¼��ʱ������棡����
            d[i][3] = Math.max(d[i-1][2]+prices[i], d[i-1][3]); // ״̬3����i��������������ڵڶ���������͵ڶ����������������У���¼��ʱ������棡����
        }

        return d[n-1][3]; // Ҫ��������ڲ���Ҫ������ͬһ�����벢�����������ƣ���ʹ״̬1�������dp����Ҳ�Ὣ��һ�ν��׵Ľ��ת�Ƶ�״̬3�У�����
    }
}