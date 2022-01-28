class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int result = 0;
        while (low < high) {
            int mid = low + (high-low)/2;
            int remainder = mid % 2; 
            if (remainder == 1) { // 关键处理：已知整个数组必为奇数个元素，若保持mid的索引为偶数，则可使二分的前后两部分皆含有偶数个元素！！！
                mid--; // 此处我们使mid减一！！！
            }
			
            if (nums[mid] == nums[mid+1]) { // 由于nums[mid]匹配到了后一个元素，意味着后半部分元素个数变为奇数个，必然包含落单的一个元素！！！
                low = mid+2; // case1：由于此时答案必然介于[mid+2, high]，result每次更新当前合理的结果即可！！！
                result = low; 
            } else { // 由于nums[mid]与后一个元素不匹配，则此时落单的元素有两种情况！！！
                high = mid; // case2：nums[mid]即为落单的元素；case3：答案介于[low, mid-2]；由于分写为3种case时LeetCode上会超时，此处else按照把两种情况都包含的写法来写！！！
                result = high;
            }
        }
        return nums[result];
    }
}