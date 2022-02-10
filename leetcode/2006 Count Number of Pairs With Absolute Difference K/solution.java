class Solution {
    public int countKDifference(int[] nums, int k) { // LeetCode第一题两数之和变体；用哈希表+一次遍历！！！
        int n = nums.length;
        Map<Integer, Integer> hashRecoed = new HashMap<>();
        int result = 0;
        for (int i=0; i<n; i++) {
            result += hashRecoed.getOrDefault(nums[i]-k, 0); // 此处由getOrDefault()代替containsKey()更方便简洁！！！
            result += hashRecoed.getOrDefault(nums[i]+k, 0);
            hashRecoed.put(nums[i], hashRecoed.getOrDefault(nums[i], 0) + 1);
        }
        return result;
    }
}