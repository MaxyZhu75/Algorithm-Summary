class Solution {
    public int trailingZeroes(int n) { // n！阶乘题目尾部的0由2*5得来，由于2的数量多于5，统计N有多少个5即可！！！
        int fives = 0; // 同样，求n！二进制表示中最低位1的位置，是统计N有多少个2！！！
        while (n != 0) {
            fives += n/5; // N所包含的5的个数由：N/5 + N/25 + N/125......！！！
            n /= 5;
        }

        return fives;
    }
}