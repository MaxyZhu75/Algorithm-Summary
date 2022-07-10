class Solution {
    public int findMin(int[] nums) { // 不含重复元素，直接常规「二分查找」！！！
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = (high-low)/2 + low;
            if (nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return nums[low];
    }
}