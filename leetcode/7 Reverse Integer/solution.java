class Solution {
    public int reverse(int x) { // 数学推导见官方题解！！！
        int reverse = 0;
        while (x != 0) {
            if (reverse < Integer.MIN_VALUE / 10 || reverse > Integer.MAX_VALUE / 10) { // 判断reverse是否属于[-2^31, 2^31 - 1]的简化条件！！！
                return 0;
            }
            int digit = x % 10; // 反转数字的常规方法！！！
            reverse = reverse * 10 + digit;
			x /= 10;
        }
        return reverse;
    }
}