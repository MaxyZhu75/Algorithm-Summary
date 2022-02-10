class Solution {
    public int minimumDifference(int[] nums, int k) { // ��������������йص�һ��Ӧ�ǻ��ݣ����Ǵ�������+�������ڼ��ɣ�����
        int n = nums.length;
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE; // java.lang.Ingeter������
        for (int i=0; i<=n-k; i++) {
            int left = i;
            int right = i+k-1;
            int current = nums[right] - nums[left];
            result = Math.min(result, current);
        }

        return result; 
    }
}