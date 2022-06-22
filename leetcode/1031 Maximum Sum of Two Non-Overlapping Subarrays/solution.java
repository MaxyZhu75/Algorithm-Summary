class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) { //��ǰ׺�͡�+����������������
        int L = firstLen, M = secondLen;
		int[] preSum = new int[nums.length+1]; // �洢ǰ׺�ͣ�����
        for(int i=1; i<=nums.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int max1 = findMax(nums, L, M, preSum); // case1������Ϊ L �����������������, ����Ϊ M ���������������ұߣ�����
        int max2 = findMax(nums, M, L, preSum); // case2������Ϊ M �����������������, ����Ϊ L ���������������ұߣ�����
        return Math.max(max1, max2);
    }
    
    private int findMax(int[] nums, int l, int r, int[] preSum){ //��l���͡�r���ֱ������ߺ��ұ�����������ĳ��ȣ�����
        int lMax = preSum[l], rSum = preSum[l+r] - preSum[l];
        int max = lMax + rSum;
        for (int i=l+1; i+r <= nums.length; i++){
            lMax = Math.max(lMax, preSum[i]-preSum[i-l]);
            rSum = preSum[i+r] - preSum[i]; // ϸ�ڣ���ߵ���������ÿ����Ҫ���£��ұߵ�����֮�Ͳ��ܹ��ص���ÿ����Ϊ�����������Ƽ��ɣ�����
            max = Math.max(max, lMax + rSum); // ����������ÿ�μ����¼��ɣ�����
        }
        return max;
    }
}