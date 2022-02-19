class Solution {
    public int minMoves2(int[] nums) { // 这是一个经典的数学问题，假设最终数组中的每个数均为x，当x为这个N个数的中位数时，可以使得距离最小！！！
        Arrays.sort(nums); // 若N为奇数，则x必须为这N个数中的唯一中位数！！！
        int n = nums.length; // 若N为偶数，中间的两个数为p和q，中位数为(p+q)/2，此时x只要是区间[p,q]中的任意一个数即可！！！
        int median = nums[n/2]; // 确定中位数的位置还可以使用快速排序，速度会更快！！！
        int result = 0;
        for (int num : nums) {
            result += Math.abs(num- median);
        }
        return result;
    }
}