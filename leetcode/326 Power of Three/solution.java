class Solution { // ����һ���Գ�������һ������Go���԰汾�𰸣�������
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n%3 == 0) { // 3����ÿ�γ�3������������������0����3���ݲ������ѭ��������
            n /= 3;   
        }
        return n == 1; 
    }
}