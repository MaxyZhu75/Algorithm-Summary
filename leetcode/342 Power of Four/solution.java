class Solution {
    public boolean isPowerOfFour(int n) {
        return n>0 && (n&(n-1))==0 && (n&0b01010101010101010101010101010101)!=0; // 三个条件：n>0 且 n只有一个1 且 该1在4的幂次位上；注意表示二进制数时要加0b!!!
    }
}