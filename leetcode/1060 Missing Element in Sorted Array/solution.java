class Solution {
    public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length-1;
        int index = 0;
        while (low <= high) { // 二分查找找到「最后一个左边缺失数字个数少于k的那个下标」！！！
            int mid = (high-low)/2 + low;
            if (missCount(nums, mid) >= k) {
                high = mid-1;
            } else {
                low = mid+1;
                index = mid;
            }
        }
        return nums[index] + (k-missCount(nums, index)); // 确实数字即nums[index]后移 k-missCount(nums, index) ！！！
    }

    public int missCount(int[] nums, int i) { // 总的空隙为nums[i]-nums[0]-1，可由索引为i推理数组中有i-1个数属于开区间(nums[0], nums[i])！！！
        return nums[i] - nums[0] - i; // 左边缺失数字统计方法：(nums[i]-nums[0]-1)-(i-1)！！！
    }
}