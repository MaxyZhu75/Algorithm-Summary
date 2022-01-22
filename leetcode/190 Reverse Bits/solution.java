public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i=31; i>=0; i--){
            int mask = n & 1; // 由于每次循环末尾会将n无符号右移一位，则此处每次循环的mask取最低位的1bit即可！！！
            int oneBit = mask << i; // 算数左移将该bit移动至相应位置！！！
            result |= oneBit; // 添加到结果用或运算！！！
            n >>>= 1;
        }
        return result;
    }
}