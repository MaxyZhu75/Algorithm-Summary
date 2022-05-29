class Solution {
    public int search(int[] nums, int target) { // 仅部分有序的二分查找！！！
        int n = nums.length;
        int low = 0, high = n-1;
        while (low <= high) { // 要点：将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序！！！
            int mid = low + (high-low)/2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) { // case1：前半部分确定有序，后半部分不确定！！！
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // target在前半部分！！！
                } else {
                    low = mid + 1; // target在后半部分！！！
                }
            } else { // case2：后半部分确定有序，前半部分不确定！！！
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // target在后半部分！！！
                } else {
                    high = mid - 1; // target在前半部分！！！
                }
            }
        }
        return -1;
    }
}