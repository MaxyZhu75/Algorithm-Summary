func isPowerOfTwo(n int) bool {
    return n>0 && (n&(n-1))==0  // ���ж� n>0 �� Integer.bitCount(n) == 1; ע�� n&(n-1) ��ȥ��n��λ����ʾ�����λ��1!!!
}