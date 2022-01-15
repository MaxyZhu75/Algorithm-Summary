class Solution {
    public boolean judgeSquareSum(int c) {
        long p1 = 0; // ע�����leetcode����������⣬��long�����գ�����
        long p2 = (long) Math.sqrt(c); // java.lang.Math�������������������Ϊ�Ͻ磬sqrt()������������������֣�ע��ʹ��ǿ��ת��������
        while( p1 <= p2 ) {
            long squareSum = p1*p1 + p2*p2;
            if (squareSum == c) {
                return true;
            } else if (squareSum < c) {
                p1++;
            } else {
                p2--;
            }
        }
        return false;
    }
}