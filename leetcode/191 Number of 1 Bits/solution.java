public class Solution {
    public int hammingWeight(int n) { // n&(n-1)消除最低位的1！！！
        int count = 0;
        while (n != 0) {
            n = n&(n-1);
            count++;
        }
        return count;
    }
}