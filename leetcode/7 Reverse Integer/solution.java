class Solution {
    public int reverse(int x) { // ��ѧ�Ƶ����ٷ���⣡����
        int reverse = 0;
        while (x != 0) {
            if (reverse < Integer.MIN_VALUE / 10 || reverse > Integer.MAX_VALUE / 10) { // �ж�reverse�Ƿ�����[-2^31, 2^31 - 1]�ļ�����������
                return 0;
            }
            int digit = x % 10; // ��ת���ֵĳ��淽��������
            reverse = reverse * 10 + digit;
			x /= 10;
        }
        return reverse;
    }
}