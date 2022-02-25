class Solution {
    public int maximumDifference(int[] nums) { // 贪心思路同LeetCode121题股票买卖问题！！！
        int currentMin = Integer.MAX_VALUE;
        int result = -1;
        for (int num : nums) {
            if (num > currentMin) {
                result = Math.max(result, num-currentMin);
            } else {
                currentMin = num;
            }
        }
        return result;
    }
}