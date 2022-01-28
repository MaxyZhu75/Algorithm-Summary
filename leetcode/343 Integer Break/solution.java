class Solution {
    public int integerBreak(int n) {
        int[] d = new int[n+1]; // ����dp������
        d[0] = 0; d[1] = 1; // basecase������
        for (int i=2; i<=n; i++) { // ��㣺��dp��������ѭ��������
            for (int j=1; j<i; j++) { // �ڲ㣺������ĳһ��ʱ��Ҫ�������п��ܵ����������
                d[i] = triMax(d[i], d[i-j]*j, (i-j)*j); // �˴�������case���������һ����©����Ϊ�ɶ����֪�˴� 0 < i-j < i����i-j����i�Ǻ���Ĳ�֣������ֲ��d[i-j]��δ����������
            }
        }
        return d[n];
    }

    public int triMax(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}