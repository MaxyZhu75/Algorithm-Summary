class Solution {
    public boolean isPalindrome(int x) { // Ҫ���ܽ�����ת��Ϊ�ַ���������
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false; // ע���0�Ҹ�λΪ0�������ǻ�����������

        int right = 0;
        while (x > right) { // Ҫ�㣺��������Ϊ���������֣���ԭʼ����С�ڻ���ڷ�ת�������ʱ������ζ�������Ѿ�������һ��λ���������ˣ�����
            right = right * 10 + x % 10;
            x /= 10;
        }

        return x == right || x == right/10; // λ��Ϊ������ż��������
    }
}