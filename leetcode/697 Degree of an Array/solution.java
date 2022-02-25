class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hashRecord = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        
        for (int i=0; i<n; i++) { // ��¼��һ�γ���λ�ã����һ�γ���λ�ã��Լ�ͳ��Ƶ�ʴ���������
            if (!hashRecord.containsKey(nums[i])) {
                firstIndex.put(nums[i], i);
            }
            hashRecord.put(nums[i], hashRecord.getOrDefault(nums[i], 0) + 1);
            lastIndex.put(nums[i],i);
        }

        int maxDegree = 0;
        int minLength = Integer.MAX_VALUE;
        for (int key : hashRecord.keySet()) {
            if (hashRecord.get(key) > maxDegree) { // case1����ǰ���ҵ�Ψһ�����Ķȣ��ϸ���ڣ�����maxDegree��minLength���и��£�����
                maxDegree = hashRecord.get(key);
                minLength = lastIndex.get(key) - firstIndex.get(key);
            } else if (hashRecord.get(key) == maxDegree) { // case2����ǰ���ҵ���Ψһ�����Ķȣ���Ҫ�ж��Ƿ����minLength������
                int currentlength = lastIndex.get(key) - firstIndex.get(key);
                minLength = (currentlength < minLength) ? currentlength : minLength;
            }
        }

        return minLength+1;
    }
}