class Solution {
    public int findKthLargest(int[] nums, int k) { // 快排中的函数partition()非常实用！！！
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right); // 返回值为当前循环所选pivot经过partition()后所在的索引位置index，其含义相当于数组内含有index个比pivot值小的元素，且已经被放置到pivot的左边！！！
            if (nums.length - index > k) {
                left = index + 1; // case1：比当前循环所选pivot大的元素多于k-1个，由于partition()已经将更大元素放置在pivot右边，第k大的元素此时肯定在pivot右边，调整左边界！！！
            } else if (nums.length - index < k) {
                right = index - 1; // case2：比当前循环所选pivot大的元素少于k-1个，由于partition()已经将更小元素放置在pivot左边，第k大的元素此时肯定在pivot左边，调整右边界！！！
            } else {
                return nums[index]; // case3：比当前循环所选pivot大的元素等于k-1个，当前pivot即为第k大的值！！！
            }
        }
    }

    private static Random random = new Random(System.currentTimeMillis()); // java.util.Random 以及 java.util.Date导包；帮助生成随机pivot减少运行时间！！！

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right-left); // random.nextInt(right-left)即生成介于[0, right-left]随机整数！！！
            swap(nums, left, randomIndex); // 将随机选取的pivot移动到最前面！！！
        }
        int pivot = nums[left];
        int j = left; // 记录pivot的合理索引位置，但在循环内并未真正交换pivot！！！
        for (int i = left+1; i<=right; i++) {
            if (nums[i] < pivot) {
                j++; // 记录pivot的合理索引位置，即统计当前比pivot小的元素个数！！！
                swap(nums, j, i);
            }
        }
        swap(nums, left, j); // 循环结束后，此处再将pivot交换至正确位置！！！
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}