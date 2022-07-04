class Solution {
    public int longestSubarray(int[] nums) { // 滑动窗口虫取法！！！
        int k = 1;
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
        return right-left-1;
    }
}