class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result = 1;
        int[] d = new int[n+1];
        d[0] = 0; // basecase������
        d[1] = 1;
        for (int i=2; i<n+1; i++) { // ��㣺��dp��ÿһ�����꣡����
            d[i] = 1; // basecaseȫ����Ϊ1������
            for (int j=1; j<i; j++) { // �ڲ㣺��ĳһ��ʱ�����������������
                if (nums[i-1] > nums[i-1-j]) {
                    d[i] = Math.max(d[i], d[i-j]+1);
                }
            }
            result = Math.max(result, d[i]); // ���µ�ǰdp������󳤶������У�����
        }
        return result;
    }
}