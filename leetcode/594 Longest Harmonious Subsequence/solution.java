class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map <Integer, Integer> hashRecord = new HashMap<>();
        for (int num : nums) {
            hashRecord.put(num, hashRecord.getOrDefault(num, 0) + 1);
        }
 
        int result = 0;
        for (int key : hashRecord.keySet()) {
            int a = hashRecord.get(key);
            if (hashRecord.containsKey(key+1)) {
                int b = hashRecord.get(key+1);
                result = Math.max(result, a+b);
            }           
        }

        return result;
    }
}