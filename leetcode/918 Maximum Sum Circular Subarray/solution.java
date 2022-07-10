class Solution {
    public int maxSubarraySumCircular(int[] nums) { // ��̬�滮���ռ��Ż��汾��Go���Դ𰸣�����
        int n = nums.length, total = 0;
        int[] dMax = new int[n+1]; // ���ڡ������м䡹�����ǡ��������͡�������
        int[] dMin = new int[n+1]; // ���ڡ��������ߡ������ǡ�total-��С������͡�������
        for (int i=1; i<=n; i++) {
            dMax[i] = Math.max(dMax[i-1]+nums[i-1], nums[i-1]);
            dMin[i] = Math.min(dMin[i-1]+nums[i-1], nums[i-1]);
            total += nums[i-1];
        }
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            maxSum = Math.max(maxSum, dMax[i]);
            minSum = Math.min(minSum, dMin[i]);
        }
        return maxSum > 0 ? Math.max(maxSum, total-minSum) : maxSum; // ϸ��:���������͡�С��0���򷵻�maxSum������
    }
}