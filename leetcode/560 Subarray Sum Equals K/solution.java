class Solution {
    public int subarraySum(int[] nums, int k) { // ǰ׺��+��ϣ������
        int prefixSum = 0;
        int result = 0;
        Map<Integer, Integer> hashRecord = new HashMap<>();
        hashRecord.put(0, 1);
        for (int i=0; i< nums.length; i++) {
            prefixSum += nums[i];
            if (hashRecord.containsKey(prefixSum-k)) { // Ҫ�㣺��ѯ��ȡ����ǰ׺��Ϊ prefixSum - k ������������
                result += hashRecord.get(prefixSum-k);
            }
            hashRecord.put(prefixSum, hashRecord.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }
}