class Solution { // ������ʹ�ô�ͳ�жϻ��ķ���isPalindrome()ʱ�临�Ӷ�Ϊn�����η���ʹ��������չ�жϻ����������̵�n��ƽ��������
    private int result = 0;
    
    public int countSubstrings(String s) {
        int n = s.length();
        for (int i=0; i<n; i++) {
            extendPalindrome(s, i, i); // �������Ȼ��ģ����Ľ�һ��Ԫ�أ�����
            extendPalindrome(s, i, i+1); // ż�����Ȼ��ģ�����������Ԫ�أ�����
        }
        return result;
    }

    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // ��������������չ��ÿ�ɹ���չһ�ν����1����ʧ���򲻱����Ե�ǰ�����չ������
            result++;
            left--;
            right++;
        }
    }
}