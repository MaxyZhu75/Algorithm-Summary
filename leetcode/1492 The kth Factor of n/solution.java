class Solution {
    public int kthFactor(int n, int k) { // ö���Ż����������n��һ������k��������Ȼ����һ������n/k����������������������һ����С�ڵ��ڸ���n�ģ�����
        int count = 0;
        int factor = 1;
        while (factor*factor <= n) { // ��1������n��factor������
            if (n % factor == 0) count++;
            if (count == k) return factor;
            factor++;
        }

        factor--; // Ҫ�㣺�˴������factor�������иô�������
        if (factor*factor == n) factor--;

        while (factor >= 1) { // �Ӹ���n��1���ر���������η��ض�Ӧ����һ������n/factor������
            if (n % factor == 0) count++;
            if (count == k) return n/factor;
            factor--;
        }

        return -1;
    }
}