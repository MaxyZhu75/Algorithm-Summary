class Solution {
    public int[] constructArray(int n, int k) { // ��ǰk+1��Ԫ�ع�����k������ͬ�Ĳ�ֵ������Ϊ��1, k+1, 2, k, 3, k-1, ... , k/2, k/2+1, k+2, k+3, ... , n-1, n ������
        int[] result = new int[n];
        result[0] = 1;
        for (int i=1, difference=k; i<=k; i++, difference--) { // ǰk+1�������湹�죡����
            result[i] = (i % 2 == 1) ? result[i-1]+difference : result[i-1]-difference;
        }
        for (int i=k+1; i<n; i++) { // ʣ�����˳������������
            result[i] = i+1;
        }
        return result;
    }
}