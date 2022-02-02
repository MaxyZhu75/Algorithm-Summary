class Solution {
    public boolean validPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length()-1;
        while (p1 < p2) {
            if (s.charAt(p1) == s.charAt(p2)) { // case1�����s�ǻ��ģ���ѭ������ʱ����true������
                p1++;
                p2--;
            } else { // case2��������Ŀ��ʾ����ɾ��һ���ַ���������һ�β���ȣ��򻹿��Ե���isPalindrome�ж�ʣ�µĲ����Ƿ��ϸ��ǻ��ģ������ٴ�ɾ����ĸ��������
                return isPalindrome(s, p1+1, p2) || isPalindrome(s, p1, p2-1); // ɾ�����ַ������������ɾ��������һ��������ļ��ɣ��˴�ֱ��return��������������
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) { // ������йص���Ŀ������Ҫ����÷�������Ҫ�������գ�����
        int p1 = i;
        int p2 = j;
        while (p1 < p2) {
            if ( s.charAt(p1) == s.charAt(p2) ) {
                p1++;
                p2--;
            } else {
                return false;
            }
        }
        return true;
    }
}