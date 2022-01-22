class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = 0; // 0����������n���0^n�������Ϊn��������
        for (int num : nums) { // ��������n���������n^n�����Ϊ0�Ľ��ۣ�������0~n�Լ�ÿ������Ԫ�ؽ��������������ý����Ϊ��Ŀ����ȱʧ����������
            result ^= num;
        }
        for (int i=0; i<=n; i++) {
            result ^= i;
        }
        return result;
    }
}