class Solution {
    public double myPow(double x, int n) { // ����һ����������ʡʱ��+�ռ䣩������
        long N = n; // Java�˴���Ҫ�Ȼ�Ϊlong��֤�����������
        return n >= 0 ? binaryPow(x, N) : 1.0 / binaryPow(x, -N); 
    }

    public double binaryPow(double x, long n) {
        double result = 1.0;
        double multiplier = x;
        while (n != 0) {
            if (n % 2 == 1) result *= multiplier; // ��ǰ�����Ʊ�ʾ�����λ�Ƿ�Ϊ1������
            n >>= 1; // ÿ�ν������Ʊ�ʾ����һλ������
            multiplier *= multiplier; // ÿ������multiplier��Ҫ��Ӧ���£�����
        }
        return result;
    }
}