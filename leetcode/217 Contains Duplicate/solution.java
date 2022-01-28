class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashRecord = new HashMap<>(); // LeetCode官方解答使用HashSet！！！
        for (int num : nums) {
            if (hashRecord.containsKey(num)) {
                return true;
            } else {
                hashRecord.put(num, 1); // 不用计具体出现次数，只用在第一次出现时标记存在即可，第二次出现会直接返回true！！！
            }
        }
        return false;
    }
}