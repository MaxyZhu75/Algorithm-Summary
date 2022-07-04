class Solution {
    public int longestOnes(int[] nums, int k) { // �������ڳ�ȡ��������
        int zero = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zero++;
            }
            if (zero > k) {
                if (nums[left] == 0) zero--;
                left++; 
            }
            right++;
        }
        return right-left;
    }
}