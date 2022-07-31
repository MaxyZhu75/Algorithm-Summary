class Solution {
    public int triangularSum(int[] nums) { // ±©Á¦½â·¨£¡£¡£¡
        for (int n=nums.length; n>0; n--) {
            for (int i=0; i<n-1; i++) {
                nums[i] = (nums[i] + nums[i+1]) % 10;
            }
        }
        return nums[0];
    }
}