class Solution {
    public int splitArray(int[] nums, int m) { // 二分查找 + 贪心；「使……最大值尽可能小」是二分查找常见的问法！！！
        int maxNum = 0, sum = 0;
		for (int i=0; i<nums.length; i++) { // 二分的上界为数组中所有元素的和，下界为数组中所有元素的最大值！！！
            sum += nums[i];
            if (maxNum < nums[i]) {
                maxNum = nums[i];
            }
        }

        int low = maxNum, high = sum; // 二分查找！！！
        while (low < high) {
            int mid = low + (high-low)/2;
            if (check(nums, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int[] nums, int upperBound, int m) { // 验证是否存在一种分割为m组的方案，满足其最大分割子数组的和不超过upperBound！！！
        int subsetSum = 0;
        int count = 1;
        for (int i=0; i<nums.length; i++) {
            if (subsetSum + nums[i] > upperBound) { // case1：若添加则越界，此处需要划分新的组！！！
                count++;
                subsetSum = nums[i];
            } else {
                subsetSum += nums[i]; // case2：添加不会越界，则视作当前组的元素！！！
            }
        }
        return count <= m; // 由于m一定大于nums.length，因此只要划分为count<m组的方案存在，划分为m组的方案也必然存在！！！
    }
}