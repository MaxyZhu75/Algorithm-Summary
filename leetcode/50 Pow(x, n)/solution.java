class Solution {
    public double myPow(double x, int n) { // 方法一：迭代（更省时间+空间）！！！
        long N = n; // Java此处需要先化为long保证不溢出！！！
        return n >= 0 ? binaryPow(x, N) : 1.0 / binaryPow(x, -N); 
    }

    public double binaryPow(double x, long n) {
        double result = 1.0;
        double multiplier = x;
        while (n != 0) {
            if (n % 2 == 1) result *= multiplier; // 当前二进制表示的最低位是否为1！！！
            n >>= 1; // 每次将二进制表示右移一位！！！
            multiplier *= multiplier; // 每次右移multiplier需要对应更新！！！
        }
        return result;
    }
}