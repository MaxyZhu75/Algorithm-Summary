class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0]=0;
        for (int i=1; i<=n; i++){
            result[i] = result[i&(i-1)] + 1; // ���� n&(n-1) ��������n�Ķ����Ʊ��ʽ�����λ��1��ԭ�������Ƴ��ñ��ʽ������
        }
        return result;
    }
}