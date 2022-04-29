class Solution {
    public void nextPermutation(int[] nums) { // 要求原地操作；解法正确性证明见LeetCode官方解答！！！
        int lastMini = nums.length-2;
        while (lastMini >= 0 && nums[lastMini] >= nums[lastMini+1]) { // 步骤一：寻找最靠后的极小值；这意味着此时该极小值后方元素必然降序排列！！！
            lastMini--;
        }
        if (lastMini >= 0) {
            int nextHigher = nums.length-1;
            while (nextHigher >= lastMini+1 && nums[lastMini] >= nums[nextHigher]) { // 步骤二：在[lastMini+1, n)从右向左查找第一个大于lastMini的数；由于该区间降序，该数满足大于lastMini的数里面最接近lastMini的数！！！
                nextHigher--;
            }
            swap(nums, lastMini, nextHigher); // 步骤三：交换两数；区间[lastMini+1, n)仍为降序！！！
        }
        reverse(nums, lastMini+1, nums.length-1); // 步骤四：将区间[lastMini+1, n)反转变为升序即可！！！
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}