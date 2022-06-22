class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) { // ��С��������1��n������k���ƶ�����k-1��λ�ã�����
            while (nums[i] > 0 && nums[i] <= n) { // ϸ�ڣ�λ�á�k-1�����ܷ���1��n��������������
                if (nums[nums[i]-1] == nums[i]) break; // ��ֹ��ѭ��������
				swap(nums, i, nums[i]-1);
            }
        }
        for (int i=0; i<n; i++) { // �����׸������������ļ����ҵ�ȱʧ������
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1; // ��Ӧȫ�����ڵ���n+1�����������
    }
	
	public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}