class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean ans = n>0 && (n&(n-1))==0; // ���ж� n>0 �� Integer.bitCount(n) == 1; ע�� n&(n-1) ��ȥ��n��λ����ʾ�����λ��1!!!
        return ans;
    }
}