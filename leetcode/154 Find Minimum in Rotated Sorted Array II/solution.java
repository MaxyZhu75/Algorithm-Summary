class Solution {
    public int findMin(int[] nums) { // 含重复元素「二分查找」！！！
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = (high-low)/2 + low;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] == nums[high]) { // 细节：单独考虑相等的情形，仅能排除high！！！
                high--;
            } else {
                low = mid+1;
            } 
        }
        return nums[low];
    }
}