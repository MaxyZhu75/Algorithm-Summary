class Solution {
    public boolean checkSubarraySum(int[] nums, int k) { // 同余定理 + 前缀和 + 哈希表！！！
        int n = nums.length;
        if (n < 2) return false;
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 存储每个余数第一次出现的下标！！！
        hashRecord.put(0, -1);
        int remainder = 0;
        for (int i=0; i<n; i++) { // 同余定理：如果两个整数 m 与 n 满足 n-m 能被 k 整除，那么 n 和 m 对 k 同余！！！
            remainder = (remainder + nums[i]) % k; // 此处运用了前缀和的思想，但此处我们只关心当前前缀和对k的余数！！！
            if (hashRecord.containsKey(remainder)) {
                int prevIndex = hashRecord.get(remainder);
                if (i - prevIndex >= 2) return true;
            } else {
                hashRecord.put(remainder, i);
            }
        }
        return false;
    }
}