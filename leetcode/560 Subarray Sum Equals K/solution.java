class Solution {
    public int subarraySum(int[] nums, int k) { // 前缀和+哈希表！！！
        int prefixSum = 0;
        int result = 0;
        Map<Integer, Integer> hashRecord = new HashMap<>();
        hashRecord.put(0, 1);
        for (int i=0; i< nums.length; i++) {
            prefixSum += nums[i];
            if (hashRecord.containsKey(prefixSum-k)) { // 要点：查询获取的是前缀和为 prefixSum - k 的数量！！！
                result += hashRecord.get(prefixSum-k);
            }
            hashRecord.put(prefixSum, hashRecord.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}