class Solution {
    public int longestSubarray(int[] nums, int limit) { // 滑动窗口虫取法 + 「Java红黑树」维护窗口内最大最小值！！！
        TreeMap<Integer, Integer> hashTree = new TreeMap<>();
        int distance = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            hashTree.put(nums[right], hashTree.getOrDefault(nums[right], 0)+1);
            if (hashTree.lastKey()-hashTree.firstKey() > limit) {
                hashTree.put(nums[left], hashTree.get(nums[left])-1);
                if (hashTree.get(nums[left]) == 0) hashTree.remove(nums[left]);
                left++;
            }
            right++;
        }
        return right-left;
    }
}