class Solution {
    public int arraySign(int[] nums) { // 仅处理符号变化即可，不需要作乘积！！！
        int sign = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) sign *= -1;
        }
        return sign;
    }
}