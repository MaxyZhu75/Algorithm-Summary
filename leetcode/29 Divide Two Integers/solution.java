class Solution {
    public int divide(int dividend, int divisor) { // 位运算；注意溢出边界问题；32位有符号整数数值范围是[?2^31, 2^31?1]！！！
        int a = dividend, b = divisor;
		if (a == -2147483648 && b == -1) { // 由无符号数表示范围总结出唯一溢出条件「?2^31/-1」;按题目要求返回 2^31?1 ！！！
			return (1<<31) - 1;	
		}

        boolean positive = (a > 0) == (b > 0); // 化为正数进行位运算操作，记录结果符号！！！
		a = abs(a);
        b = abs(b);
		
        int result = 0;
        for (int i=31; i>=0; i--) { // 对于当前a，判断除以2^i后是否大于等于b；即判断2^i乘b是否小于等于a！！！
            if ((a >>> i) - b >= 0) { // 写为减法可防止a等于 2^31 时产生溢出！！！
                result += (1 << i); // 结果添加乘数 2^i ！！！
                a -= (b << i); // 将2^i乘b从a中除去！！！
            }
		}
        return positive ? result : -result;
    }
	
    public int abs(int num) {
		if (num < 0) {
			return -num;
		} else {
			return num;
		}
	}
}