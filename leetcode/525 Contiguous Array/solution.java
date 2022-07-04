class Solution {
    public int findMaxLength(int[] nums) { // 前缀和延伸！！！
        int n = nums.length;
        int[] pSum = new int[n+1];
        for (int i=1; i<=n; i++) { // 将为0的元素当做-1处理，从而将问题转化为求区间和为0的最长子数组，即pSum相等的最远的两处下标！！！
		    pSum[i] = pSum[i-1] + (nums[i-1] == 1 ? 1 : -1);
		}
        int result = 0;
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 记录「某个pSum首次出现的位置」！！！
        for (int i=2; i<=n; i++) {
            if (!hashRecord.containsKey(pSum[i-2])) { // 若该pSum是首次出现，即为最左侧！！！
			    hashRecord.put(pSum[i-2], i-2);
			}
            if (hashRecord.containsKey(pSum[i])) { // 不是首次出现，尝试更新最远距离！！！
			    result = Math.max(result, i-hashRecord.get(pSum[i]));
			}
        }
        return result;
    }
}