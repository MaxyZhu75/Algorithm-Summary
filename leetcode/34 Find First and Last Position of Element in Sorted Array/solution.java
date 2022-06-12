class Solution {
    public int[] searchRange(int[] nums, int target) { // 两种模式的二分查找；左右边界需要不同判断条件！！！
        int left = partition(nums, target, 0); // 查找第一个大于等于target的下标；即LeetCode第35题！！！
        int right = partition(nums, target, 1) - 1; // 查找第一个大于target的下标，然后减去1！！！
        if (left <= right && nums[left] == target && nums[right] == target) { // 筛选有效结果！！！
            return new int[]{left, right};
        } 
        return new int[]{-1, -1};
    }

    public int partition(int[] nums, int target, int mode) {
        int low = 0, high = nums.length-1, result = nums.length; // 细节：查找失败时返回的是数组长度n！！！
        while (low <= high) {
            int mid = (high-low)/2 + low;
            if (nums[mid] > target || (mode == 0 && nums[mid] >= target)) { // 增加对模式的判断！！！
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}