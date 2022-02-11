class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashRecord = new HashMap<>(); // import java.util.HashMap ��ס����������
        int[] result = new int[2];
        for (int i=0; i<n; i++){
            int checkNum = target-nums[i];
            if (hashRecord.containsKey(checkNum)){ // HashMap.containsKey(key)������
                result[0] = i;
                result[1] = hashRecord.get(checkNum); // HashMap.get(key)������
                return result;
            } else {
                hashRecord.put(nums[i],i);  // map�в�����nums[i]��keyʱ��������������������map������
            }
        }
        return result;
    }
}