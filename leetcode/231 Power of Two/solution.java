class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean ans = n>0 && (n&(n-1))==0; // 即判断 n>0 且 Integer.bitCount(n) == 1; 注意 n&(n-1) 可去除n的位级表示中最低位的1!!!
        return ans;
    }
}