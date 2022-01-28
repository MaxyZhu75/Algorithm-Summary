class Solution {
    public int removePalindromeSub(String s) {
        if ( isPalindrome(s, 0, s.length()-1) ) { // ����Ŀ�ؼ�������������壨�����У����ģ���������׾ٵؽ������ע���������У��������������У�����
            return 1;
        } else {
            return 2;
        }
    }

    public boolean isPalindrome(String s, int i, int j) { // ������йص���Ŀ������Ҫ����÷�������Ҫ�������գ���
        int p1 = i;
        int p2 = j;
        while (p1 < p2) {
            if (s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }
}