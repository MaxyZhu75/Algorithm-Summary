class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int result = 0;
        while (n != 0) {
            n = n&(n-1); // ��n&(n-1)���������n�����Ʊ�ʾ�����λ��1�����⼴����x��y���Ľ��n��Ҫ�������ٸ�1���ɣ��൱��java.lang.Integer.bitCount(x^y)������
            result++;
        }
        return result;
    }
}