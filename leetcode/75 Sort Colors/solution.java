class Solution {
    public void sortColors(int[] nums) { // 双指针解决「荷兰国旗问题」！！！
        int n = nums.length;
        int p0 = 0, p2 = n-1; // 分别用来交换0和2！！！
        for (int i=0; i<=p2; i++) {
            while (i <= p2 && nums[i] == 2) { // while循环确保「位置i最终不是2」！！！
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0) { // 此处if判别即可！！！
                swap(nums, i, p0);
                p0++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}