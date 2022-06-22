class Solution {
    public int numSquares(int n) { // ����ƽ���Ͷ�����ѧ�ⷨ���㷨��ȷ��֤�����ٷ���⣡����
        if (isSquare(n)) {
            return 1;
        }
        if (isCase4(n)) {
            return 4;
        }
        for (int i=1; i*i <= n; i++) {
            int j = n - i*i;
            if (isSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    public boolean isSquare(int n) { // �ж��Ƿ�Ϊ��ȫƽ����������
        int a = (int)Math.sqrt(n);
        return a*a == n;
    }

    public boolean isCase4(int n) { // �ж��Ƿ����㡸n = 4^k*(8m+7)��������
        while (n % 4 == 0) {
            n /= 4;
        }
        return n % 8 == 7;
    }
}