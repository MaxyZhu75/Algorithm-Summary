class Solution {
    public boolean judgeSquareSum(int c) {
        long p1 = 0; // 注意此题leetcode上有溢出问题，用long更保险！！！
        long p2 = (long) Math.sqrt(c); // java.lang.Math调用算数根号运算后作为上界，sqrt()仅保留结果的整数部分；注意使用强制转换！！！
        while( p1 <= p2 ) {
            long squareSum = p1*p1 + p2*p2;
            if (squareSum == c) {
                return true;
            } else if (squareSum < c) {
                p1++;
            } else {
                p2--;
            }
        }
        return false;
    }
}