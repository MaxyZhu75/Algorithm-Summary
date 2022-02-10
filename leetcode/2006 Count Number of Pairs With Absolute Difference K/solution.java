class Solution {
    public int countKDifference(int[] nums, int k) { // LeetCode��һ������֮�ͱ��壻�ù�ϣ��+һ�α���������
        int n = nums.length;
        Map<Integer, Integer> hashRecoed = new HashMap<>();
        int result = 0;
        for (int i=0; i<n; i++) {
            result += hashRecoed.getOrDefault(nums[i]-k, 0); // �˴���getOrDefault()����containsKey()�������࣡����
            result += hashRecoed.getOrDefault(nums[i]+k, 0);
            hashRecoed.put(nums[i], hashRecoed.getOrDefault(nums[i], 0) + 1);
        }
        return result;
    }
}