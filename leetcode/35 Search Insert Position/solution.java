class Solution {
    public int searchInsert(int[] nums, int target) { // 即查找第一个大于等于target的下标！！！
        int n = nums.length;
        int low = 0, high = n-1, result = n;
        while (low <= high) {
            int mid = (high-low)/2 + low; // 细节：查找失败时（数组所有元素小于target）返回的是数组长度n！！！
            if (nums[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}