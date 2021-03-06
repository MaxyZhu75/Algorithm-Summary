class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0]=0;
        for (int i=1; i<=n; i++){
            result[i] = result[i&(i-1)] + 1; // 根据 n&(n-1) 可以消除n的二进制表达式中最低位的1的原理，可以推出该表达式！！！
        }
        return result;
    }
}