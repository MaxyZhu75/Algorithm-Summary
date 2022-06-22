class Solution {
    public int[] sortArray(int[] nums) { // 调用「快速排序」！！！
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right); // 返回值为当前循环所选pivot经过partition()后所在的索引位置index，其含义相当于数组内含有index个比pivot值小的元素，且已经被放置到pivot的左边！！！
            quickSort(nums, left, index-1);
            quickSort(nums, index+1, right);
        }
    }

    private int partition(int[] nums, int left, int right) { // 快排partition()固定写法！！！
		Random random = new Random(System.currentTimeMillis());
        if (left < right) {
            int randomIndex = left + 1 + random.nextInt(right-left); // random.nextInt(right-left)即生成介于[0, right-left)随机整数！！！
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