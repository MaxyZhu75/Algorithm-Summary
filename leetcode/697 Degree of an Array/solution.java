class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hashRecord = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        
        for (int i=0; i<n; i++) { // 记录第一次出现位置，最后一次出现位置，以及统计频率次数！！！
            if (!hashRecord.containsKey(nums[i])) {
                firstIndex.put(nums[i], i);
            }
            hashRecord.put(nums[i], hashRecord.getOrDefault(nums[i], 0) + 1);
            lastIndex.put(nums[i],i);
        }

        int maxDegree = 0;
        int minLength = Integer.MAX_VALUE;
        for (int key : hashRecord.keySet()) {
            if (hashRecord.get(key) > maxDegree) { // case1：当前所找到唯一的最大的度（严格大于），对maxDegree与minLength进行更新！！！
                maxDegree = hashRecord.get(key);
                minLength = lastIndex.get(key) - firstIndex.get(key);
            } else if (hashRecord.get(key) == maxDegree) { // case2：当前所找到不唯一的最大的度，需要判断是否更新minLength！！！
                int currentlength = lastIndex.get(key) - firstIndex.get(key);
                minLength = (currentlength < minLength) ? currentlength : minLength;
            }
        }

        return minLength+1;
    }
}