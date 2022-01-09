class Solution {
    public boolean hasAlternatingBits(int n) {
        int r = n>>1; // 1）算数右移>>：相当于除以2n，高位由符号位填充 2）无符号右移>>>：高位补0
        int oneNum = ((n^r)+1); // 满足01交叉的n经过该异或操作后得到全为1的数，再加1后进位，oneNum仅含一个1!!!
        return (oneNum&(oneNum-1))==0; // 判断oneNum二进制表示是否满足仅含一个1!!!
    }
}