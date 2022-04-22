class Solution {
    public long subArrayRanges(int[] nums) { // ���׽ⷨΪ����ջ������
        int n = nums.length;
        long result = 0;
        for (int i=0; i<n; i++) { // ����ÿ������Ϊ�����еĿ�ͷ������
            int min = nums[i];
            int max = nums[i];
            for (int j=i+1; j<n; j++) { // ��̬���µ�ǰ���������ֵ��Сֵ����������������
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += (long)max-min;
            }
        }
        return result;
    }
}