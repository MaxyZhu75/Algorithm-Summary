class Solution {
    public int singleNumber(int[] nums) {
        int result = 0; // 0����������n���0^n�������Ϊn��������
        for (int num : nums) {
            result ^= num; // ����n���������n^n�������Ϊ0������
        }
        return result;
    }
}