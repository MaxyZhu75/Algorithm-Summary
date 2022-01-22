class Solution {
    public int singleNumber(int[] nums) {
        int result = 0; // 0与任意整数n异或（0^n），结果为n本身！！！
        for (int num : nums) {
            result ^= num; // 整数n与自身异或（n^n），结果为0！！！
        }
        return result;
    }
}