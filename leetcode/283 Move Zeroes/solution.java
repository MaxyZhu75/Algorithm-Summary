class Solution {
    public void moveZeroes(int[] nums) { // 一次遍历考虑双指针或直接按照索引覆盖！！！
        int n = nums.length;
        int nonZeroIndex = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        for (int i=nonZeroIndex; i<n; i++) {
            nums[i] = 0;
        }
    }
}