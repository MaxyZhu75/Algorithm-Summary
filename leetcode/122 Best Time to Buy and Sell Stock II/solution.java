class Solution { // �ɰ�����DP״̬ת������������Go���԰汾�𰸣������˴����ڽ��״��������ƿ���ֱ��̰�ģ�����LeetCode188���������Ƚϣ�������
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        for (int i=1; i<n; i++) { // Ҫ�㣺�����������ĸ���[a, b, c, d]���������Ϊ d - a���� d - a = (d - c) + (c - b) + (b - a)������
            result += Math.max(0, prices[i]-prices[i-1]); // ̰�ģ�����prices[i]����prices[i]-prices[i-1]>0����ֱ�Ӱ�prices[i]-prices[i-1]��ӵ������У�����
        }
        return result;
    }
}