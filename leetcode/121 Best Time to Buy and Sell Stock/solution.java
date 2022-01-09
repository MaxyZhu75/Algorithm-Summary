class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0; // ��==�Ƚϣ�����д��Ϊ=
        int currentMin = prices[0]; // ��ʼֵΪ��һ��ɼ�!!!
        int maxProfit = 0;
        for(int i=0; i<n; i++){
            if( prices[i] < currentMin ) {
                currentMin = prices[i]; // if-else �ṹ���������������������������ͬһ�����������!!!
            } else {
                maxProfit = Math.max(maxProfit, prices[i]-currentMin); // java.lang.Math!!!
            }
        }
        return maxProfit;
    }
}