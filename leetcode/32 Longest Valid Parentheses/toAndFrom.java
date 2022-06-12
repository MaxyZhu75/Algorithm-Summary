class Solution {
    public int longestValidParentheses(String s) { // ̰�� + �����������ϡ�������
        int left = 0, right = 0; // ͳ��������������������
		int result = 0;
        for (int i=0; i<s.length(); i++) { // ���򣡣���
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) { // case1����������������ȣ����Ը��¼������Ч���ŵĳ��ȣ�����
                result = Math.max(result, left+right);
            } else if (right > left) { // case2�������Ŷ��������ţ�������Ϊ0������
                left = 0;
				right = 0;
            } // case3�������Ŷ��������ţ�������ʾ��������
        }

        left = 0;
		right = 0;
        for (int i=s.length()-1; i >= 0; i--) { // ���򣻷�ֹ©���������ʱ������ʼ�ն��������ŵ����޷�ͳ�ƽ�������������
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left+right);
            } else if (left > right) {
                left = 0;
				right = 0;
            }
        }
        return result;
    }
}