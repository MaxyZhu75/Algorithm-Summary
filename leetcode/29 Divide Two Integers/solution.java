class Solution {
    public int divide(int dividend, int divisor) { // λ���㣻ע������߽����⣻32λ�з���������ֵ��Χ��[?2^31, 2^31?1]������
        int a = dividend, b = divisor;
		if (a == -2147483648 && b == -1) { // ���޷�������ʾ��Χ�ܽ��Ψһ���������?2^31/-1��;����ĿҪ�󷵻� 2^31?1 ������
			return (1<<31) - 1;	
		}

        boolean positive = (a > 0) == (b > 0); // ��Ϊ��������λ�����������¼������ţ�����
		a = abs(a);
        b = abs(b);
		
        int result = 0;
        for (int i=31; i>=0; i--) { // ���ڵ�ǰa���жϳ���2^i���Ƿ���ڵ���b�����ж�2^i��b�Ƿ�С�ڵ���a������
            if ((a >>> i) - b >= 0) { // дΪ�����ɷ�ֹa���� 2^31 ʱ�������������
                result += (1 << i); // �����ӳ��� 2^i ������
                a -= (b << i); // ��2^i��b��a�г�ȥ������
            }
		}
        return positive ? result : -result;
    }
	
    public int abs(int num) {
		if (num < 0) {
			return -num;
		} else {
			return num;
		}
	}
}