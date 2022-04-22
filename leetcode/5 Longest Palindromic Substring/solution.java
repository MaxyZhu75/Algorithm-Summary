class Solution {
    public String longestPalindrome(String s) { // ����������չ������LeetCode647�⣡����
        int start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            int odd = expandPalindrome(s, i, i); // �������Ȼ��ģ����Ľ�һ��Ԫ�أ�����
            int even = expandPalindrome(s, i, i + 1); // ż�����Ȼ��ģ�����������Ԫ�أ�����
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len-1)/2; // ����յ������ļ��㣡����
                end = i + len/2;
            }
        }
        return s.substring(start, end+1); // ע���ǡ�end+1��������
    }

    public int expandPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // ��������������չ��ÿ�ɹ���չһ�ν����1����ʧ���򲻱����Ե�ǰ�����չ������
            right++;
			left--;
        }
        return right - left - 1;
    }
}